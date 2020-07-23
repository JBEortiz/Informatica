package com.empresa.informatica.service;

import java.util.List;

import com.empresa.informatica.entity.Empleado;

public interface EmpleadoService {

	List<Empleado> findAll();

	Empleado createEmpleado(Empleado empleado);

	Empleado findByIdEmpleado(Long id);

	Empleado updateEmpleado(Empleado empleado);

	void deleteEmpleado(Long id);

}
