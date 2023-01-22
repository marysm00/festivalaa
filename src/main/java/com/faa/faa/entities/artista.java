package com.faa.faa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "artista")
public class artista {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_artista", nullable = false)
	private Long id_artista;

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

	public artista(Long id_artista, String nombre, String apellidos, Long id_solapin, String sexo, String modalidad) {
		super();
		this.id_artista = id_artista;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id_solapin = id_solapin;
		this.sexo = sexo;
		this.modalidad = modalidad;
	}

	public artista(String nombre, String apellidos, Long id_solapin, String sexo, String modalidad) {
		super();
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.id_solapin = id_solapin;
		this.sexo = sexo;
		this.modalidad = modalidad;
	}

	public artista() {
		super();
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public Long getId_artista() {
		return id_artista;
	}

	public void setId_artista(Long id_artista) {
		this.id_artista = id_artista;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
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

}
