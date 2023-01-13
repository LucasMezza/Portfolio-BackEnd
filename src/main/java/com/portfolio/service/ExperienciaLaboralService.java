package com.portfolio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.model.ExperienciaLaboral;
import com.portfolio.repository.ExperienciaLaboralRepository;

@Service
@Transactional
public class ExperienciaLaboralService {

	@Autowired
	ExperienciaLaboralRepository experienciaLaboralRepository;
	
	 public List<ExperienciaLaboral> list(){
	        return experienciaLaboralRepository.findAll();
	    }

	    public Optional<ExperienciaLaboral> getOne(long id){
	        return experienciaLaboralRepository.findById(id);
	    }

	    public Optional<ExperienciaLaboral> getByNombre(String nombre){
	        return experienciaLaboralRepository.findByNombre(nombre);
	    }

	    public void  save(ExperienciaLaboral experienciaLaboral){
	        experienciaLaboralRepository.save(experienciaLaboral);
	    }
	   

	    public void delete(Long id){
	        experienciaLaboralRepository.deleteById(id);
	    }

	    public boolean existsById(long id){
	        return experienciaLaboralRepository.existsById(id);
	    }

	    public boolean existsByNombre(String nombre){
	        return experienciaLaboralRepository.existsByNombre(nombre);
	    }
	
}