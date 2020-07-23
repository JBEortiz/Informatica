package com.empresa.informatica.service;

import java.util.List;

import com.empresa.informatica.entity.Proyecto;

public interface ProyectoService {

	List<Proyecto> findAll();

	Proyecto createProyecto(Proyecto proyecto);

	Proyecto findByIdProyecto(Long id);

	Proyecto updateProyecto(Proyecto proyecto);

	void deleteProyecto(Long id);
}
