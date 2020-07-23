package com.empresa.informatica.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.informatica.entity.Proyecto;

@Repository
public class ProyectoRepositoryImpl implements ProyectoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Proyecto> findAll() {
		return entityManager.createQuery("from Proyecto").getResultList();
	}

	@Override
	@Transactional
	public Proyecto createProyecto(Proyecto proyecto) {
		entityManager.persist(proyecto);
		return proyecto;
	}

	@Override
	@Transactional(readOnly = true)
	public Proyecto findByIdProyecto(Long id) {
		return entityManager.find(Proyecto.class, id);
	}

	@Override
	@Transactional
	public Proyecto updateProyecto(Proyecto proyecto) {
		return entityManager.merge(proyecto);
	}

	@Override
	@Transactional
	public void deleteProyecto(Long id) {
		Proyecto proyecto = findByIdProyecto(id);
		if (proyecto != null) {
			entityManager.remove(proyecto);
		} else {
			Logger.getLogger("no se ha podido borrar, por que no se ha encontrado");
		}

	}

	@Override
	public Proyecto IdProyecto(Long id) {
		return (Proyecto) entityManager.createQuery("SELECT t FROM Proyecto t WHERE t.id = ?1").getSingleResult();
	}

}
