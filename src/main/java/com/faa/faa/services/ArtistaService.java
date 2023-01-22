package com.faa.faa.services;

import java.util.List;

import com.faa.faa.entities.artista;

public interface ArtistaService {

	public List<artista> findAll();

	public artista findById(Long Id);

	public void save(artista a);

	public void deleteById(Long Id);

	public void update(artista a);

}
