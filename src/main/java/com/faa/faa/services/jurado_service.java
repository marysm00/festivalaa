package com.faa.faa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faa.faa.entities.jurado;
import com.faa.faa.repository.juradoRepository;

@Service
public class jurado_service implements JuradoService {

	public juradoRepository jurRep;

	@Autowired
	public jurado_service(juradoRepository JurRep) {

		jurRep = JurRep;
	}

	@Override
	public List<jurado> findAll() {

		return jurRep.findAll();
	}

	@Override
	public jurado findById(Long Id) {

		return jurRep.findById(Id).get();
	}

	@Override
	public void save(jurado j) {

		jurRep.save(j);
	}

	@Override
	public void deleteById(Long Id) {

		jurRep.deleteById(Id);
	}

	@Override
	public void update(jurado j) {

		jurRep.save(j);
	}

	public List<jurado> findBynombre(String nombre) {
		return jurRep.findBynombre(nombre);
	}

}
