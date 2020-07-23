package com.empresa.informatica.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.empresa.informatica.entity.Empleado;
import com.empresa.informatica.service.EmpleadoService;

@RestController
@RequestMapping("/empleado")
public class EmpleadoController {
	@Autowired
	private EmpleadoService service;

	@GetMapping
	public ResponseEntity<?> getAllEmpleado() {
		List<Empleado> empleado = new ArrayList<>();
		empleado = service.findAll();
		if (empleado.isEmpty()) {
			return new ResponseEntity<List<Empleado>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Empleado>>(empleado, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Empleado> findEmpleado(@PathVariable Long id) {
		Empleado empleado = service.findByIdEmpleado(id);
		if (empleado == null || id <= 0 || id == null) {
			return new ResponseEntity<Empleado>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Empleado>(empleado, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<?> createEmpleado(@RequestBody Empleado empleado) {
		Empleado empleadoAdd = service.createEmpleado(empleado);
		return ResponseEntity.status(HttpStatus.CREATED).body(empleadoAdd);
	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteEmpleado(@PathVariable Long id) {
		if (id == null || id <= 0) {
			return new ResponseEntity<Empleado>(HttpStatus.NO_CONTENT);
		}
		service.deleteEmpleado(id);

		return ResponseEntity.noContent().build();
	}
}
