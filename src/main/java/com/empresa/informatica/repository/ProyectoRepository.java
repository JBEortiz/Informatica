package com.empresa.informatica.repository;

import java.util.List;

import com.empresa.informatica.entity.Proyecto;

public interface ProyectoRepository {

	List<Proyecto> findAll();

	Proyecto createProyecto(Proyecto proyecto);

	Proyecto findByIdProyecto(Long id);

	Proyecto updateProyecto(Proyecto proyecto);

	void deleteProyecto(Long id);

	Proyecto IdProyecto(Long id);
}
