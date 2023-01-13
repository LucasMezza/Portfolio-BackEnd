package com.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.model.Proyecto;

public interface ProyectoRepository extends JpaRepository<Proyecto, Long>{

	Optional<Proyecto> findByNombre(String nombre);
	boolean existsByNombre(String nombre);
}