package com.portfolio.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.portfolio.model.Proyecto;
import com.portfolio.repository.ProyectoRepository;

@Service
@Transactional
public class ProyectoService {

	@Autowired
	ProyectoRepository proyectoRepository;
	
	 public List<Proyecto> list(){
	        return proyectoRepository.findAll();
	    }

	    public Optional<Proyecto> getOne(long id){
	        return proyectoRepository.findById(id);
	    }

	    public Optional<Proyecto> getByNombre(String nombre){
	        return proyectoRepository.findByNombre(nombre);
	    }

	    public void  save(Proyecto proyecto){
	        proyectoRepository.save(proyecto);
	    }
	   

	    public void delete(Long id){
	        proyectoRepository.deleteById(id);
	    }

	    public boolean existsById(long id){
	        return proyectoRepository.existsById(id);
	    }

	    public boolean existsByNombre(String nombre){
	        return proyectoRepository.existsByNombre(nombre);
	    }
}