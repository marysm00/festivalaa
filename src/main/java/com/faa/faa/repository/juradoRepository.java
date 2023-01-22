package com.faa.faa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faa.faa.entities.jurado;

public interface juradoRepository extends JpaRepository<jurado, Long> {

	@Query(value = "select * from jurado j where j.nombre like %:nombre%", nativeQuery = true)
	public List<jurado> findBynombre(String nombre);
}
