package com.faa.faa.services;

import java.util.List;

import com.faa.faa.entities.jurado;

public interface JuradoService {

	public List<jurado> findAll();

	public jurado findById(Long Id);

	public void save(jurado j);

	public void deleteById(Long Id);

	public void update(jurado j);
}
