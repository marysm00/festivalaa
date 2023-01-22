package com.faa.faa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "formulario")
public class formulario {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_formulario", nullable = false)
	private Long id_formulario;

	@Column(name = "nombre", nullable = false)
	private String nombre;

	@Column(name = "apellidos", nullable = false)
	private String apellidos;

	@Column(name = "sexo", nullable = false)
	private String sexo;

	@Column(name = "ocupacion", nullable = false)
	private String ocupacion;

	@Column(name = "id_solapin", nullable = false)
	private Long id_solapin;

	@Column(name = "facultad", nullable = false)
	private String facultad;

	@Column(name = "modalidad", nullable = false)
	private String modalidad;

	public formulario(Long id_formulario, String nombre, String apellidos, String sexo, String ocupacion,
			Long id_solapin, String facultad, String modalidad) {
		super();
		this.id_formulario = id_formulario;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.ocupacion = ocupacion;
		this.id_solapin = id_solapin;
		this.facultad = facultad;
		this.modalidad = modalidad;
	}

	public formulario(String nombre, String apellidos, String sexo, String ocupacion, Long id_solapin, String facultad,
			String modalidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.ocupacion = ocupacion;
		this.id_solapin = id_solapin;
		this.facultad = facultad;
		this.modalidad = modalidad;
	}

	public formulario() {
		super();
	}

	public Long getId_formulario() {
		return id_formulario;
	}

	public void setId_formulario(Long id_formulario) {
		this.id_formulario = id_formulario;
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

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getOcupacion() {
		return ocupacion;
	}

	public void setOcupacion(String ocupacion) {
		this.ocupacion = ocupacion;
	}

	public Long getId_solapin() {
		return id_solapin;
	}

	public void setId_solapin(Long id_solapin) {
		this.id_solapin = id_solapin;
	}

	public String getFacultad() {
		return facultad;
	}

	public void setFacultad(String facultad) {
		this.facultad = facultad;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

}
