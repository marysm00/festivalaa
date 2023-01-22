package com.faa.faa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.faa.faa.entities.formulario;
import com.faa.faa.repository.formularioRepository;

@Service
public class formulario_service implements FormularioService {

	public formularioRepository forRep;

	@Autowired
	public formulario_service(formularioRepository ForRep) {

		forRep = ForRep;
	}

	@Override
	public List<formulario> findAll() {
		return forRep.findAll();
	}

	@Override
	public formulario findById(Long Id) {

		return forRep.findById(Id).get();
	}

	@Override
	public void save(formulario f) {
		forRep.save(f);

	}

	@Override
	public void deleteById(Long Id) {
		forRep.deleteById(Id);

	}

	@Override
	public void update(formulario f) {
		forRep.save(f);

	}

	public List<formulario> findBynombre(String nombre) {
		return forRep.findBynombre(nombre);
	}
}
