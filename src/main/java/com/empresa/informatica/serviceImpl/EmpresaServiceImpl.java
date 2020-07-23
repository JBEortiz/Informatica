package com.empresa.informatica.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.empresa.informatica.dto.EmpresaEmpleadoProyectoDTO;
import com.empresa.informatica.entity.Empleado;
import com.empresa.informatica.entity.Empresa;
import com.empresa.informatica.entity.Proyecto;
import com.empresa.informatica.repository.EmpleadoRepository;
import com.empresa.informatica.repository.EmpresaRepository;
import com.empresa.informatica.repository.ProyectoRepository;
import com.empresa.informatica.service.EmpresaService;

@Service
public class EmpresaServiceImpl implements EmpresaService {

	@Autowired
	private EmpresaRepository empresaRepository;
	@Autowired
	private EmpleadoRepository empleadoRepository;
	@Autowired
	private ProyectoRepository proyectoRepository;

	@Override
	public List<Empresa> findAll() {
		return empresaRepository.findAll();
	}

	@Override
	public Empresa createEmpresa(Empresa empresa) {
		return empresaRepository.createEmpresa(empresa);
	}

	@Override
	public Empresa findByIdEmpresa(Long id) {
		return empresaRepository.findByIdEmpresa(id);
	}

	@Override
	public Empresa updateEmpresa(Empresa empresa) {
		return empresaRepository.updateEmpresa(empresa);
	}

	@Override
	public void deleteEmpresa(Long id) {
		empresaRepository.deleteEmpresa(id);
	}

	@Override
	public void addEmpresaProyectoEmpleado(EmpresaEmpleadoProyectoDTO empresaEmpleadoProyectoDTO) {
		Empresa empresa = empresaRepository.IdEmpresa(empresaEmpleadoProyectoDTO.getIdEmpresa());
		Empleado empleado = empleadoRepository.IdEmpleado(empresaEmpleadoProyectoDTO.getIdEmpleado());
		Proyecto proyecto = proyectoRepository.IdProyecto(empresaEmpleadoProyectoDTO.getIdProyecto());
		empresa.getEmpleados().add(empleado);
		empresa.getProyectos().add(proyecto);
		empresaRepository.createEmpresa(empresa);

	}

//	@Override
//	public void addEmpresaProyectoEmpleado(EmpresaEmpleadoProyectoDTO empresaEmpleadoProyectoDTO) {
//		Empresa empresa = empresaRepository.findByIdEmpresa(empresaEmpleadoProyectoDTO.getIdEmpresa());
//		Empleado empleado = empleadoRepository.findByIdEmpleado(empresaEmpleadoProyectoDTO.getIdEmpleado());
//		Proyecto proyecto = proyectoRepository.findByIdProyecto(empresaEmpleadoProyectoDTO.getIdProyecto());
//
//		empresa.getEmpleados().add(empleado);
//		empresa.getProyectos().add(proyecto);
//		empresaRepository.createEmpresa(empresa);
//	}

}
