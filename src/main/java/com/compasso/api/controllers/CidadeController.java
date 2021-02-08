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
import com.compasso.api.models.Cidade;
import com.compasso.api.services.CidadeService;
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
@Api (tags = {"Cidades"})
@CrossOrigin(origins = "*")
@RequestMapping(value = "/api/")
@ApiResponses(value = { 
        @ApiResponse(code = 200, message = "Successo|OK"),
        @ApiResponse(code = 201, message = "Criado com successo"),
        @ApiResponse(code = 400, message = "Requisição Inválida"), 
        @ApiResponse(code = 404, message = "Não encontrado") })
public class CidadeController {

	@Autowired
	private CidadeService cidadeSevice;

    @GetMapping(path = "/cidades")
    @ApiOperation("Lista todas as cidades")
	public List<Cidade> listarTodasCidades() {
		return cidadeSevice.listar();
	}

	@GetMapping(path = "/cidades/{parametro}")
    @ApiOperation("Lista cidades pelo { nome } ou { estado }")
	public List<Cidade> listarPorNomeOuEstado(@PathVariable("parametro") String parametro) {
		return cidadeSevice.listarCidade(parametro);
	}

    @PostMapping(path = "/cidades")
    @ApiOperation("Realiza o cadastro de uma cidade")
	public ResponseEntity<Cidade> cadastrarCidade(@RequestBody Cidade cidade) {
		return cidadeSevice.salvar(cidade);
	}

    @PutMapping(path = "/cidades/{id}")
    @ApiOperation("Realiza a edição de uma cidade pelo { id }")
	public ResponseEntity<Cidade> editarCidade(@PathVariable("id") long id, @RequestBody Cidade cidade) {
		return cidadeSevice.editar(id, cidade);
	}

    @DeleteMapping("/cidades/{id}")
    @ApiOperation("Realiza a exclusão uma cidade pelo { id }")
	public ResponseEntity<Cidade> excluirCidade(@PathVariable("id") long id) {
		return cidadeSevice.excluir(id);
	}
}
