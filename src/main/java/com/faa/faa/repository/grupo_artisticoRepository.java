package com.faa.faa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faa.faa.entities.grupo_artistico;

public interface grupo_artisticoRepository extends JpaRepository<grupo_artistico, Long> {
	
	@Query(value = "select * from grupo_artistico g where g.nombre like %:nombre%", nativeQuery = true)
	public List<grupo_artistico> findBynombre(String nombre);

}
