package com.faa.faa.services;

import java.util.List;

import com.faa.faa.entities.premio;

public interface PremioService {

	public List<premio> findAll();

	public premio findById(Long Id);

	public void save(premio p);

	public void deleteById(Long Id);

	public void update(premio p);
}
