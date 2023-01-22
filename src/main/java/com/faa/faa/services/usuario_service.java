package com.faa.faa.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.faa.faa.entities.usuario;
import com.faa.faa.repository.usuarioRepository;

@Service
public class usuario_service implements UsuarioService {

	public usuarioRepository usuRep;

	@Autowired
	public usuario_service(usuarioRepository UsuRep) {

		usuRep = UsuRep;
	}

	@Override
	public List<usuario> findAll() {
		return usuRep.findAll();
	}

	@Override
	public usuario findById(Long Id) {

		return usuRep.findById(Id).get();
	}

	@Override
	public void save(usuario u) {
		usuRep.save(u);

	}

	@Override
	public void deleteById(Long Id) {
		usuRep.deleteById(Id);

	}

	@Override
	public void update(usuario u) {
		usuRep.save(u);
	}

	public List<usuario> findBynombre(String nombre) {
		return usuRep.findBynombre(nombre);
	}
}
