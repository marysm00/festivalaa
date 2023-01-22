package com.faa.faa.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.faa.faa.entities.premio;

public interface premioRepository extends JpaRepository<premio, Long> {

	@Query(value = "select * from premio p where p.participante like %:participante%", nativeQuery = true)
	public List<premio> findBynombre(String participante);
}
