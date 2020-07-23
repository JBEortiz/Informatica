package com.empresa.informatica.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column
	private String nombre;
	@OneToMany(cascade = CascadeType.PERSIST, mappedBy = "empresa")
	private List<Cliente> clientes;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Proyecto> proyectos;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "empresa")
	private List<Empleado> empleados;

	public Empresa() {
	}

	public Empresa(Long id, String nombre, List<Cliente> clientes, List<Proyecto> proyectos, List<Empleado> empleados) {
		this.id = id;
		this.nombre = nombre;
		this.clientes = clientes;
		this.proyectos = proyectos;
		this.empleados = empleados;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public List<Proyecto> getProyectos() {
		return proyectos;
	}

	public void setProyectos(List<Proyecto> proyectos) {
		this.proyectos = proyectos;
	}

	public List<Empleado> getEmpleados() {
		return empleados;
	}

	public void setEmpleados(List<Empleado> empleados) {
		this.empleados = empleados;
	}

}
