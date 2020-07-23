package com.empresa.informatica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.informatica.entity.Proyecto;
import com.empresa.informatica.service.ProyectoService;

@RestController
@RequestMapping("/proyecto")
public class ProyectoController {

	@Autowired
	private ProyectoService service;

	@GetMapping
	public ResponseEntity<?> getAllProyecto() {
		List<Proyecto> proyecto = new ArrayList<>();
		proyecto = service.findAll();
		if (proyecto.isEmpty()) {
			return new ResponseEntity<List<Proyecto>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Proyecto>>(proyecto, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Proyecto> findProyecto(@PathVariable Long id) {
		Proyecto proyecto = service.findByIdProyecto(id);
		if (proyecto == null || id <= 0 || id == null) {
			return new ResponseEntity<Proyecto>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<?> createProyecto(@RequestBody Proyecto proyecto) {
		Proyecto proyectoAdd = service.createProyecto(proyecto);
		return ResponseEntity.status(HttpStatus.CREATED).body(proyectoAdd);
	}

}
