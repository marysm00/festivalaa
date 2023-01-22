package com.faa.faa.services;

import java.util.List;

import com.faa.faa.entities.usuario;

public interface UsuarioService {

	public List<usuario> findAll();

	public usuario findById(Long Id);

	public void save(usuario u);

	public void deleteById(Long Id);

	public void update(usuario u);

}
