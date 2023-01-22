package com.faa.faa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "jurado")
public class jurado {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_jurado", nullable = false)
	private Long id_jurado;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "id_solapin", nullable = false)
	private Long id_solapin;

	@Column(name = "sexo", nullable = false)
	private String sexo;

	@Column(name = "modalidad", nullable = false)
	private String modalidad;

	@Column(name = "centro_trabajo", nullable = false)
	private String centro_trabajo;

	public jurado(Long id_jurado, String nombre, String apellidos, Long id_solapin, String sexo, String modalidad,
			String centro_trabajo) {
		super();
		this.id_jurado = id_jurado;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id_solapin = id_solapin;
		this.sexo = sexo;
		this.modalidad = modalidad;
		this.centro_trabajo = centro_trabajo;
	}

	public jurado(String nombre, String apellidos, Long id_solapin, String sexo, String modalidad,
			String centro_trabajo) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id_solapin = id_solapin;
		this.sexo = sexo;
		this.modalidad = modalidad;
		this.centro_trabajo = centro_trabajo;
	}

	public jurado() {

	}

	public Long getId_jurado() {
		return id_jurado;
	}

	public void setId_jurado(Long id_jurado) {
		this.id_jurado = id_jurado;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getId_solapin() {
		return id_solapin;
	}

	public void setId_solapin(Long id_solapin) {
		this.id_solapin = id_solapin;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getCentro_trabajo() {
		return centro_trabajo;
	}

	public void setCentro_trabajo(String centro_trabajo) {
		this.centro_trabajo = centro_trabajo;
	}
}
