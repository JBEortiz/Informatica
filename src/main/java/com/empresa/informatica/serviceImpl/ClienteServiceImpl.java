package com.empresa.informatica.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.informatica.entity.Cliente;
import com.empresa.informatica.repository.ClienteRepository;
import com.empresa.informatica.service.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;

	@Override
	public List<Cliente> findAll() {
		return clienteRepository.findAll();
	}

	@Override
	public Cliente createCliente(Cliente cliente) {
		return clienteRepository.createCliente(cliente);
	}

	@Override
	public Cliente findByIdCliente(Long id) {
		return clienteRepository.findByIdCliente(id);
	}

	@Override
	public Cliente updateCliente(Cliente cliente) {

		Cliente clienteUpdate = new Cliente();
		clienteUpdate.setNombre(cliente.getNombre());
		return clienteRepository.updateCliente(cliente);
	}

	@Override
	public void deleteCliente(Long id) {
		clienteRepository.deleteCliente(id);
	}

}
