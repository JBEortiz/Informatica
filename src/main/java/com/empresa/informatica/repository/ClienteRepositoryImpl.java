package com.empresa.informatica.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.informatica.entity.Cliente;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Cliente> findAll() {
		return entityManager.createQuery("from Cliente").getResultList();
	}

	@Override
	@Transactional
	public Cliente createCliente(Cliente cliente) {
		entityManager.persist(cliente);
		return cliente;
	}

	@Override
	@Transactional(readOnly = true)
	public Cliente findByIdCliente(Long id) {
		return entityManager.find(Cliente.class, id);
	}

	@Override
	@Transactional
	public Cliente updateCliente(Cliente cliente) {
		return entityManager.merge(cliente);
	}

	@Override
	@Transactional
	public void deleteCliente(Long id) {
		Cliente cliente = findByIdCliente(id);
		if (cliente != null) {
			entityManager.remove(cliente);
		} else {
			Logger.getLogger("no se ha podido borrar, por que no se ha encontrado");
		}

	}

}
