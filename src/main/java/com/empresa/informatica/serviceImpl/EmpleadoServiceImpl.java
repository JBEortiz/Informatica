package com.empresa.informatica.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.informatica.entity.Empleado;
import com.empresa.informatica.repository.EmpleadoRepository;
import com.empresa.informatica.service.EmpleadoService;

@Service
public class EmpleadoServiceImpl implements EmpleadoService {

	@Autowired
	private EmpleadoRepository empleadoRepository;

	@Override
	public List<Empleado> findAll() {
		return empleadoRepository.findAll();
	}

	@Override
	public Empleado createEmpleado(Empleado empleado) {
		return empleadoRepository.createEmpleado(empleado);
	}

	@Override
	public Empleado findByIdEmpleado(Long id) {
		return empleadoRepository.findByIdEmpleado(id);
	}

	@Override
	public Empleado updateEmpleado(Empleado empleado) {
		Empleado empleadoUpdate = new Empleado();
		empleadoUpdate.setTipo(empleado.getTipo());
		return empleadoRepository.updateEmpleado(empleado);
	}

	@Override
	public void deleteEmpleado(Long id) {
		empleadoRepository.deleteEmpleado(id);
	}

}
