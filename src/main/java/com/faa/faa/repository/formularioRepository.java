package com.faa.faa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faa.faa.entities.formulario;

public interface formularioRepository extends JpaRepository<formulario, Long> {

	@Query(value = "select * from formulario f where f.nombre like %:nombre%", nativeQuery = true)
	public List<formulario> findBynombre(String nombre);
}
