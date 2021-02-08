package com.compasso.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.compasso.api.models.Cliente;
import com.compasso.api.services.ClienteService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 *
 * @author Rodrigo da Cruz
 * @version 1.0
 * @since 2021-01-05
 * 
 */

@RestController
@Api(tags = { "Clientes" })
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/")
@ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successo|OK"),
        @ApiResponse(code = 201, message = "Criado com successo"),
        @ApiResponse(code = 400, message = "Requisição Inválida"), 
        @ApiResponse(code = 404, message = "Não encontrado") })
public class ClienteController {

	@Autowired
	private ClienteService clienteService;

	@GetMapping(path = "/clientes")
	@ApiOperation("Lista todos os clientes")
	public List<Cliente> listarTodosClientes() {
		return clienteService.listar();
	}

	@GetMapping(path = "/clientes/{parametro}")
	@ApiOperation("Lista clientes pelo { nome } ou { id }")
	public List<Cliente> listarPorNomeOuId(@PathVariable("parametro") String parametro) {
		return clienteService.listarCliente(parametro);
	}

	@PostMapping(path = "/clientes")
	@ApiOperation("Realiza o cadastro de um cliente")
	public ResponseEntity<Cliente> cadastrarCliente(@RequestBody Cliente cliente) {
		return clienteService.salvar(cliente);
	}

	@PutMapping(path = "/clientes/{id}")
	@ApiOperation("Realiza a edição de um cliente pelo { id }")
	public ResponseEntity<Cliente> editarCliente(@PathVariable("id") long id, @RequestBody Cliente cliente) {
		return clienteService.editar(id, cliente);
	}

	@DeleteMapping("/clientes/{id}")
	@ApiOperation("Realiza a exclusão um cliente pelo { id }")
	public ResponseEntity<Cliente> excluirCliente(@PathVariable("id") long id) {
		return clienteService.excluir(id);
	}
}
