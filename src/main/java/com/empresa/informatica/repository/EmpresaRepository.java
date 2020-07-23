package com.empresa.informatica.repository;

import java.util.List;

import com.empresa.informatica.entity.Empresa;

public interface EmpresaRepository {

	List<Empresa> findAll();

	Empresa createEmpresa(Empresa empresa);

	Empresa findByIdEmpresa(Long id);

	Empresa updateEmpresa(Empresa empresa);

	void deleteEmpresa(Long id);

	Empresa IdEmpresa(Long id);
}
