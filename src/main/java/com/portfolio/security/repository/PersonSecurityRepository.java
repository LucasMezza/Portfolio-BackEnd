package com.portfolio.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.portfolio.model.Person;

public interface PersonSecurityRepository extends JpaRepository<Person , Long>{
	Optional<Person> findByNombre(String nombre);
	boolean existsByNombre(String nombre);
}