package com.faa.faa.services;

import java.util.List;

import com.faa.faa.entities.formulario;

public interface FormularioService {

	public List<formulario> findAll();

	public formulario findById(Long Id);

	public void save(formulario f);

	public void deleteById(Long Id);

	public void update(formulario f);
}
