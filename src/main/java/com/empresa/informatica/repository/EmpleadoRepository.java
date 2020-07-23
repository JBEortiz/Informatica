package com.empresa.informatica.repository;

import java.util.List;

import com.empresa.informatica.entity.Empleado;

public interface EmpleadoRepository {

	List<Empleado> findAll();

	Empleado createEmpleado(Empleado empleado);

	Empleado findByIdEmpleado(Long id);

	Empleado updateEmpleado(Empleado empleado);

	void deleteEmpleado(Long id);

	Empleado IdEmpleado(Long id);
}
