package com.portfolio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.model.Educacion;
import com.portfolio.repository.EducacionRepository;

@Service
@Transactional
public class EducacionService {

	@Autowired
	EducacionRepository educacionRepository;
	
	 public List<Educacion> list(){
	        return educacionRepository.findAll();
	    }

	    public Optional<Educacion> getOne(long id){
	        return educacionRepository.findById(id);
	    }

	    public Optional<Educacion> getByNombre(String nombre){
	        return educacionRepository.findByNombre(nombre);
	    }

	    public void  save(Educacion educacion){
	        educacionRepository.save(educacion);
	    }
	   

	    public void delete(Long id){
	        educacionRepository.deleteById(id);
	    }

	    public boolean existsById(long id){
	        return educacionRepository.existsById(id);
	    }

	    public boolean existsByNombre(String nombre){
	        return educacionRepository.existsByNombre(nombre);
	    }
	
}