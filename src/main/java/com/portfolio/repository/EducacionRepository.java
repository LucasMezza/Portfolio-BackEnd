package com.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.model.Educacion;


public interface EducacionRepository extends JpaRepository<Educacion, Long>{
	Optional<Educacion> findByNombre(String nombre);
	boolean existsByNombre(String nombre);
}