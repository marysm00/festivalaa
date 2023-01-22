package com.faa.faa.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "premio")
public class premio {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_premio", nullable = false)
	private Long id_premio;

	@Column(name = "participante", nullable = false)
	private String participante;

	@Column(name = "modalidad", nullable = false)
	private String modalidad;

	@Column(name = "obra", nullable = false)
	private String obra;

	@Column(name = "anno", nullable = false)
	private int anno;

	@Column(name = "tipo_premio", nullable = false)
	private String tipo_premio;

	public premio(Long id_premio, String participante, String modalidad, String obra, int anno, String tipo_premio) {
		super();
		this.id_premio = id_premio;
		this.participante = participante;
		this.modalidad = modalidad;
		this.obra = obra;
		this.anno = anno;
		this.tipo_premio = tipo_premio;
	}

	public premio(String participante, String modalidad, String obra, int anno, String tipo_premio) {
		super();
		this.participante = participante;
		this.modalidad = modalidad;
		this.obra = obra;
		this.anno = anno;
		this.tipo_premio = tipo_premio;
	}

	public premio() {
		super();
	}

	public Long getId_premio() {
		return id_premio;
	}

	public void setId_premio(Long id_premio) {
		this.id_premio = id_premio;
	}

	public String getParticipante() {
		return participante;
	}

	public void setParticipante(String participante) {
		this.participante = participante;
	}

	public String getModalidad() {
		return modalidad;
	}

	public void setModalidad(String modalidad) {
		this.modalidad = modalidad;
	}

	public String getObra() {
		return obra;
	}

	public void setObra(String obra) {
		this.obra = obra;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

	public String getTipo_premio() {
		return tipo_premio;
	}

	public void setTipo_premio(String tipo_premio) {
		this.tipo_premio = tipo_premio;
	}

}
