package com.faa.faa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "grupo_artistico")
public class grupo_artistico {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_grupo_artistico", nullable = false)
	private Long id_grupo_artistico;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "modalidad", nullable = false)
	private String modalidad;

	public grupo_artistico(Long id_grupo_artistico, String nombre, String modalidad) {
		super();
		this.id_grupo_artistico = id_grupo_artistico;
		this.nombre = nombre;
		this.modalidad = modalidad;
	}

	public grupo_artistico(String nombre, String modalidad) {
		super();
		this.nombre = nombre;
		this.modalidad = modalidad;
	}

	public grupo_artistico() {
		super();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public Long getId_grupo_artistico() {
		return id_grupo_artistico;
	}

	public void setId_grupo_artistico(Long id_grupo_artistico) {
		this.id_grupo_artistico = id_grupo_artistico;
	}

}
