package com.faa.faa.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faa.faa.entities.premio;
import com.faa.faa.repository.premioRepository;

@Service
public class premio_service implements PremioService {

	public premioRepository preRep;

	@Autowired
	public premio_service(premioRepository PreRep) {

		preRep = PreRep;
	}

	@Override
	public List<premio> findAll() {

		return preRep.findAll();
	}

	@Override
	public premio findById(Long Id) {

		return preRep.findById(Id).get();
	}

	@Override
	public void save(premio p) {
		preRep.save(p);

	}

	@Override
	public void deleteById(Long Id) {
		preRep.deleteById(Id);

	}

	@Override
	public void update(premio p) {
		preRep.save(p);
	}

	public List<premio> findBynombre(String nombre) {
		return preRep.findBynombre(nombre);
	}

}
