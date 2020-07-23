package com.empresa.informatica.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.informatica.entity.Empresa;

@Repository
public class EmpresaRepositoryImpl implements EmpresaRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Empresa> findAll() {
		return entityManager.createQuery("from Empresa").getResultList();
	}

	@Override
	@Transactional
	public Empresa createEmpresa(Empresa empresa) {
		entityManager.persist(empresa);
		return empresa;
	}

	@Override
	@Transactional(readOnly = true)
	public Empresa findByIdEmpresa(Long id) {

		return entityManager.find(Empresa.class, id);

	}

	@Override
	@Transactional
	public Empresa updateEmpresa(Empresa empresa) {
		entityManager.merge(empresa);
		return empresa;
	}

	@Override
	@Transactional
	public void deleteEmpresa(Long id) {
		Empresa empresa = findByIdEmpresa(id);
		if (empresa != null) {
			entityManager.remove(empresa);
		} else {
			Logger.getLogger("no se ha podido borrar, por que no se ha encontrado");
		}
	}

	@Override
	@Transactional
	public Empresa IdEmpresa(Long id) {
		return (Empresa) entityManager.createQuery("SELECT e FROM Empresa e WHERE e.id = ?1").getSingleResult();
	}

}
