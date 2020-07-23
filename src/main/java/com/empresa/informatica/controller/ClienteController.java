package com.empresa.informatica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.informatica.entity.Cliente;
import com.empresa.informatica.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping
	public ResponseEntity<?> getAllCliente() {
		List<Cliente> cliente = new ArrayList<>();
		cliente = service.findAll();
		if (cliente.isEmpty()) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Cliente> findCliente(@PathVariable Long id) {
		Cliente cliente = service.findByIdCliente(id);
		if (cliente == null || id <= 0 || id == null) {
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Cliente>(cliente, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<?> createCliente(@RequestBody Cliente cliente) {
		Cliente clienteAdd = service.createCliente(cliente);
		return ResponseEntity.status(HttpStatus.CREATED).body(clienteAdd);
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteCliente(@PathVariable Long id) {
		if (id == null || id <= 0) {
			return new ResponseEntity<Cliente>(HttpStatus.NO_CONTENT);
		}
		service.deleteCliente(id);

		return ResponseEntity.noContent().build();
	}
}
