package com.faa.faa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faa.faa.entities.artista;
import com.faa.faa.repository.artistaRepository;

@Service
public class artista_service implements ArtistaService {

	public artistaRepository artRep;

	@Autowired
	public artista_service(artistaRepository ArtRep) {

		artRep = ArtRep;
	}

	@Override
	public List<artista> findAll() {
		return artRep.findAll();
	}

	@Override
	public artista findById(Long Id) {

		return artRep.findById(Id).get();
	}

	@Override
	public void save(artista a) {
		artRep.save(a);

	}

	@Override
	public void deleteById(Long Id) {
		artRep.deleteById(Id);

	}

	@Override
	public void update(artista a) {
		artRep.save(a);

	}

	public List<artista> findBynombre(String nombre) {
		return artRep.findBynombre(nombre);
	}

}
