package com.empresa.informatica.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.informatica.entity.Proyecto;
import com.empresa.informatica.repository.ProyectoRepository;
import com.empresa.informatica.service.ProyectoService;

@Service
public class ProyectoServiceImpl implements ProyectoService {

	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public List<Proyecto> findAll() {
		return proyectoRepository.findAll();
	}

	@Override
	public Proyecto createProyecto(Proyecto proyecto) {
		return proyectoRepository.createProyecto(proyecto);
	}

	@Override
	public Proyecto findByIdProyecto(Long id) {
		return proyectoRepository.findByIdProyecto(id);
	}

	@Override
	public Proyecto updateProyecto(Proyecto proyecto) {
		return proyectoRepository.updateProyecto(proyecto);
	}

	@Override
	public void deleteProyecto(Long id) {
		proyectoRepository.deleteProyecto(id);
	}

}
