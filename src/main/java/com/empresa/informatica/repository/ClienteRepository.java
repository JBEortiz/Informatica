package com.empresa.informatica.repository;

import java.util.List;

import com.empresa.informatica.entity.Cliente;

public interface ClienteRepository {
	List<Cliente> findAll();

	Cliente createCliente(Cliente cliente);

	Cliente findByIdCliente(Long id);

	Cliente updateCliente(Cliente cliente);

	void deleteCliente(Long id);
}
