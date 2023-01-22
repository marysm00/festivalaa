package com.faa.faa.services;

import java.util.List;

import com.faa.faa.entities.grupo_artistico;

public interface Grupo_artisticoService {

	public List<grupo_artistico> findAll();

	public grupo_artistico findById(Long Id);

	public void save(grupo_artistico g);

	public void deleteById(Long Id);

	public void update(grupo_artistico g);
}
