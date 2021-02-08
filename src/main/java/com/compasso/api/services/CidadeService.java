package com.compasso.api.services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.compasso.api.models.Cidade;
import com.compasso.api.repositories.CidadeRepository;
import com.compasso.api.services.exceptions.EntityNotFoundException;
import com.compasso.api.services.exceptions.EntityValidationException;
import com.compasso.api.util.GenericSpesification;
import com.compasso.api.util.SearchCriteria;
import com.compasso.api.util.SearchOperation;

/**
*
* @author Rodrigo da Cruz
* @version 1.0
* @since 2021-02-06
* 
*/

@Service
public class CidadeService {
	
    @Autowired
    private CidadeRepository cidadeRepository;
    
	/*
	 * Lista todos os registros
	 */
	public List<Cidade> listar() {
		return cidadeRepository.findAll();
	}

	/*
	 * Retorna a lista com os registros filtrados
	 */
	public List<Cidade> listarCidade(String parametro) {
		if (filtrarCidade(parametro).isEmpty()) {
			throw new EntityNotFoundException("O objeto solicitado não pôde ser encontrado");
		}
		return filtrarCidade(parametro);
	}
	
	/*
	 * Filtra os registros por  NOME ou ESTADO
	 */
	public List<Cidade> filtrarCidade(String parametro) {
		GenericSpesification<Cidade> genericSpesification = new GenericSpesification<Cidade>();
		String obj = (parametro.length() == 0 || parametro.length() == 2) ? "estado" : "nome";
		genericSpesification.add(new SearchCriteria(obj, parametro, SearchOperation.MATCH));
		return cidadeRepository.findAll(genericSpesification);
	}

	/*
	 * Cadastro de um novo resgitro
	 */
	public ResponseEntity<Cidade> salvar(@Valid Cidade cidade) {
		return new ResponseEntity<>(cidadeRepository.save(cidade), HttpStatus.CREATED);
	}

	/*
	 * Edição de um registro
	 */
	public ResponseEntity<Cidade> editar(long id, @Valid Cidade cidade) {
		Cidade data = cidadeRepository.findById(id).get();
		data.setNome(cidade.getNome());
		data.setEstado(cidade.getEstado());
		return new ResponseEntity<>(cidadeRepository.save(data), HttpStatus.OK);
	}
	
	/*
	 *  Exclusão de um registro
	 */
	public ResponseEntity<Cidade> excluir(long id) {
		try {
			cidadeRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			throw new EntityValidationException("O registro não pôde ser removido");
		}
	}
}
