package com.empresa.informatica.service;

import java.util.List;

import com.empresa.informatica.dto.EmpresaEmpleadoProyectoDTO;
import com.empresa.informatica.entity.Empresa;

public interface EmpresaService {

	List<Empresa> findAll();

	Empresa createEmpresa(Empresa empresa);

	Empresa findByIdEmpresa(Long id);

	Empresa updateEmpresa(Empresa empresa);

	void deleteEmpresa(Long id);

	void addEmpresaProyectoEmpleado(EmpresaEmpleadoProyectoDTO empresaEmpleadoProyectoDTO);

}
