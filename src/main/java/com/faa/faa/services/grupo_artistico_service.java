package com.faa.faa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.faa.faa.entities.grupo_artistico;
import com.faa.faa.repository.grupo_artisticoRepository;

@Service
public class grupo_artistico_service implements Grupo_artisticoService {

	public grupo_artisticoRepository gruRep;

	@Autowired
	public grupo_artistico_service(grupo_artisticoRepository GruRep) {

		gruRep = GruRep;
	}

	@Override
	public List<grupo_artistico> findAll() {
		return gruRep.findAll();
	}

	@Override
	public grupo_artistico findById(Long Id) {

		return gruRep.findById(Id).get();
	}

	@Override
	public void save(grupo_artistico g) {
		gruRep.save(g);

	}

	@Override
	public void deleteById(Long Id) {
		gruRep.deleteById(Id);

	}

	@Override
	public void update(grupo_artistico g) {
		gruRep.save(g);

	}

	public List<grupo_artistico> findBynombre(String nombre) {
		return gruRep.findBynombre(nombre);
	}

}
