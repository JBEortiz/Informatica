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

import com.empresa.informatica.dto.EmpresaEmpleadoProyectoDTO;
import com.empresa.informatica.entity.Empresa;
import com.empresa.informatica.service.EmpresaService;

@RestController
@RequestMapping("/empresa")
public class EmpresaController {
	@Autowired
	private EmpresaService service;

	@GetMapping
	public ResponseEntity<?> getAllEmpresa() {
		List<Empresa> empresa = new ArrayList<>();
		empresa = service.findAll();
		if (empresa.isEmpty()) {
			return new ResponseEntity<List<Empresa>>(HttpStatus.NO_CONTENT);

		}
		return new ResponseEntity<List<Empresa>>(empresa, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Empresa> findEmpresa(@PathVariable Long id) {
		Empresa empresa = service.findByIdEmpresa(id);
		if (empresa == null || id <= 0 || id == null) {
			return new ResponseEntity<Empresa>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Empresa>(empresa, HttpStatus.OK);

	}

	@PostMapping("/create")
	public ResponseEntity<?> createEmpresa(@RequestBody Empresa empresa) {
		Empresa empresaAdd = service.createEmpresa(empresa);
		return ResponseEntity.status(HttpStatus.CREATED).body(empresaAdd);
	}

	@PostMapping("/contratarEmpleadoAsignarProyecto")
	public ResponseEntity<EmpresaEmpleadoProyectoDTO> contratarEmpleadoAsignarProyecto(
			@RequestBody EmpresaEmpleadoProyectoDTO empresaEmpleadoProyectoDTO) {

		service.addEmpresaProyectoEmpleado(empresaEmpleadoProyectoDTO);
		return new ResponseEntity<EmpresaEmpleadoProyectoDTO>(HttpStatus.OK);

	}

	@DeleteMapping("/borrar/{id}")
	public ResponseEntity<?> deleteEmpresa(@PathVariable Long id) {
		if (id == null || id <= 0) {
			return new ResponseEntity<Empresa>(HttpStatus.NO_CONTENT);
		}
		service.deleteEmpresa(id);

		return ResponseEntity.noContent().build();
	}
}