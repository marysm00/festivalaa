package com.faa.faa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faa.faa.entities.artista;

public interface artistaRepository extends JpaRepository<artista, Long> {

	@Query(value = "select * from artista a where a.nombre like %:nombre%", nativeQuery = true)
	public List<artista> findBynombre(String nombre);

}
