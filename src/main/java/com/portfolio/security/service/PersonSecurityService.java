package com.portfolio.security.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.portfolio.model.Person;
import com.portfolio.security.repository.PersonSecurityRepository;

@Service
@Transactional
public class PersonSecurityService {
	@Autowired
	PersonSecurityRepository usuarioRepository;
	
	public Optional<Person> getByNombre(String nombre) {
		return usuarioRepository.findByNombre(nombre);
	}
	
	public boolean existsByNombre(String nombre) {
		return usuarioRepository.existsByNombre(nombre);
	}
	
	public void save(Person person) {
		usuarioRepository.save(person);
	}
	
	  public void delete(Long id){
	        usuarioRepository.deleteById(id);
	    }

	    public boolean existsById(Long id){
	        return usuarioRepository.existsById(id);
	    }
}
