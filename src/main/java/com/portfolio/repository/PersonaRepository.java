package com.portfolio.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.model.Person;

public interface PersonaRepository extends JpaRepository<Person, Long> {

	Optional<Person> findByNombre(String nombre);
	boolean existsByNombre(String nombre);
	
}
