package com.compasso.api.services;

import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.compasso.api.models.Cliente;
import com.compasso.api.repositories.ClienteRepository;
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
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	/*
	 * Lista todos os registros
	 */
	public List<Cliente> listar() {
		return clienteRepository.findAll();
	}

	/*
	 * Retorna a lista de registros filtrados
	 */
	public List<Cliente> listarCliente(String parametro) {
		if (filtrarCliente(parametro).isEmpty()) {
			throw new EntityNotFoundException("O objeto solicitado não pôde ser encontrado");
		}
		return filtrarCliente(parametro);
	}

	/*
	 * Filtra um registro por ID ou NOME
	 */
	public List<Cliente> filtrarCliente(String parametro) {
		GenericSpesification<Cliente> genericSpesification = new GenericSpesification<Cliente>();
		boolean obj = parametro.matches("^[a-zA-ZÁÂÃÀÇÉÊÍÓÔÕÚÜáâãàçéêíóôõúü]*$");
		genericSpesification.add(new SearchCriteria(obj ? "nome" : "id", parametro, obj ? SearchOperation.MATCH : SearchOperation.EQUAL));
		return clienteRepository.findAll(genericSpesification);
	}

	/*
	 * Cadastro de um novo resgitro
	 */
	public ResponseEntity<Cliente> salvar(@Valid Cliente cliente) {
		return new ResponseEntity<>(clienteRepository.save(cliente), HttpStatus.CREATED);
	}

	/*
	 * Edição de um registro
	 */
	public ResponseEntity<Cliente> editar(long id, @Valid Cliente cliente) {
		Cliente data = clienteRepository.findById(id).get();
		data.setNome(cliente.getNome());
		data.setSexo(cliente.getSexo());
		data.setData_nascimento(cliente.getData_nascimento());
		data.setIdade(cliente.getIdade());
		data.setCidade(cliente.getCidade());
		return new ResponseEntity<>(clienteRepository.save(data), HttpStatus.OK);
	}

	/*
	 * TransactionSystemException Exclusão de um registro
	 */
	public ResponseEntity<Cliente> excluir(long id) {
		try {
			clienteRepository.deleteById(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception ex) {
			throw new EntityValidationException("O registro não pôde ser removido");
		}
	}
}
