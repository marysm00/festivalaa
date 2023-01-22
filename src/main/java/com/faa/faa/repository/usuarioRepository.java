package com.faa.faa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faa.faa.entities.usuario;

public interface usuarioRepository extends JpaRepository<usuario, Long> {
	
	@Query(value = "select * from usuario u where u.nombre like %:nombre%", nativeQuery = true)
	public List<usuario> findBynombre(String nombre);

}
