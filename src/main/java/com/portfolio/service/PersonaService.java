package com.portfolio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.model.Person;
import com.portfolio.repository.PersonaRepository;

@Service
@Transactional
public class PersonaService {
	
	@Autowired
	PersonaRepository personaRepository;

    public List<Person> list(){
        return personaRepository.findAll();
    }

    public Optional<Person> getOne(Long id){
        return personaRepository.findById(id);
    }

    public Optional<Person> getByNombre(String nombre){
        return personaRepository.findByNombre(nombre);
    }

    public void  save(Person persona){
    	personaRepository.save(persona);
    }
   

    public void delete(Long id){
    	personaRepository.deleteById(id);
    }

    public boolean existsById(Long id){
        return personaRepository.existsById(id);
    }

    public boolean existsByNombre(String nombre){
        return personaRepository.existsByNombre(nombre);
    }
}
