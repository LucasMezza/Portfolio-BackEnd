package com.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.model.ExperienciaLaboral;

public interface ExperienciaLaboralRepository extends JpaRepository<ExperienciaLaboral, Long>{
	Optional<ExperienciaLaboral> findByNombre(String nombre);
	boolean existsByNombre(String nombre);
}