package com.compasso.api.services.exceptions;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
*
* @author Rodrigo da Cruz
* @version 1.0
* @since 2021-02-06
* 
*/

@ControllerAdvice
public class ResourceExceptionHandler {

	@ExceptionHandler(EntityNotFoundException.class)
	public ResponseEntity<StandardError> entityNotFound(EntityNotFoundException e, HttpServletRequest request) {
		StandardError erros = new StandardError();
		erros.setTimestamp(Instant.now());
		erros.setStatus(HttpStatus.NOT_FOUND.value());
		erros.setError("Não encontrado");
		erros.setMessage(e.getMessage());
		erros.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erros);
	}
	
	@ExceptionHandler(EntityValidationException.class)
	public ResponseEntity<StandardError> entityValidation(EntityValidationException e, HttpServletRequest request) {
		StandardError erros = new StandardError();
		erros.setTimestamp(Instant.now());
		erros.setStatus(HttpStatus.BAD_REQUEST.value());
		erros.setError("Requisição Inválida");
		erros.setMessage(e.getMessage());
		erros.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}

	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<StandardError> errorHandlerOverJson(HttpServletRequest request, RuntimeException exception) {
		StandardError erros = new StandardError();
		erros.setTimestamp(Instant.now());
		erros.setStatus(HttpStatus.BAD_REQUEST.value());
		erros.setError("Requisição Inválida");
		erros.setMessage("Sua requisição não pôde ser processada");
		erros.setPath(request.getRequestURI());
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erros);
	}

	@ExceptionHandler({ ConstraintViolationException.class })
	public ResponseEntity<Map<String, Object>> entityExceptionHandler(ConstraintViolationException e) {
		Map<String, Object> response = new HashMap<String, Object>();
		Map<String, String> errors = new HashMap<String, String>();
		Set<ConstraintViolation<?>> constraintViolations = e.getConstraintViolations();

		for (ConstraintViolation<?> constraintViolation : constraintViolations) {
			errors.put(constraintViolation.getPropertyPath().toString(), constraintViolation.getMessage());
		}
		response.put("error", errors);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
	}

}
