package com.empresa.informatica.repository;

import java.util.List;
import java.util.logging.Logger;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.empresa.informatica.entity.Empleado;

@Repository
public class EmpleadoRepositroyImpl implements EmpleadoRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	public List<Empleado> findAll() {
		return entityManager.createQuery("from Empleado").getResultList();
	}

	@Override
	@Transactional
	public Empleado createEmpleado(Empleado empleado) {
		entityManager.persist(empleado);
		return empleado;
	}

	@Override
	@Transactional(readOnly = true)
	public Empleado findByIdEmpleado(Long id) {
		return entityManager.find(Empleado.class, id);
	}

	@Override
	@Transactional
	public Empleado updateEmpleado(Empleado empleado) {
		return entityManager.merge(empleado);
	}

	@Override
	@Transactional
	public void deleteEmpleado(Long id) {
		Empleado empleado = findByIdEmpleado(id);
		if (empleado != null) {
			entityManager.remove(empleado);
		} else {
			Logger.getLogger("no se ha podido borrar, por que no se ha encontrado");
		}

	}

	@Override
	public Empleado IdEmpleado(Long id) {

		return (Empleado) entityManager.createQuery("SELECT p FROM Empleado p WHERE p.id = ?1").getSingleResult();
	}
}
