package com.faa.faa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
public class usuario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_usuario", nullable = false)
	private Long id_usuario;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "contrasenna", nullable = false)
	private String contrasenna;

	public usuario(Long id_usuario, String nombre, String contrasenna) {
		super();
		this.id_usuario = id_usuario;
		this.nombre = nombre;
		this.contrasenna = contrasenna;
	}

	public usuario(String nombre, String contrasenna) {
		super();
		this.nombre = nombre;
		this.contrasenna = contrasenna;
	}

	public usuario() {
		super();
	}

	public Long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

}
