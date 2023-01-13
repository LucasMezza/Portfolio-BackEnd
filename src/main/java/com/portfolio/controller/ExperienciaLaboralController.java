package com.portfolio.controller;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.portfolio.dto.ExperienciaLaboralDto;
import com.portfolio.dto.Mensaje;

import com.portfolio.model.ExperienciaLaboral;

import com.portfolio.service.ExperienciaLaboralService;


@RestController
@RequestMapping("/experienciaLaboral")
@CrossOrigin(origins = "*")
public class ExperienciaLaboralController {

	

	 @Autowired
	 ExperienciaLaboralService experienciaLaboralService;
	 
	 @GetMapping("/lista") 
	    public ResponseEntity<List<ExperienciaLaboral>> list(){
	        List<ExperienciaLaboral> list = experienciaLaboralService.list();
	        return new ResponseEntity<List<ExperienciaLaboral>>(list, HttpStatus.OK);
	    }
	 
	  @GetMapping("/detail/{id}")
	    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
	        if(!experienciaLaboralService.existsById(id))
	            return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        ExperienciaLaboral persona = experienciaLaboralService.getOne(id).get();
	        return new ResponseEntity<Object>(persona, HttpStatus.OK);
	    }
	  
	  @GetMapping("/detailname/{nombre}")
	    public ResponseEntity<ExperienciaLaboral> getByNombre(@PathVariable("nombre") String nombre){
	        if(!experienciaLaboralService.existsByNombre(nombre))
	            return new ResponseEntity<ExperienciaLaboral>(HttpStatus.NOT_FOUND);
	        ExperienciaLaboral persona = experienciaLaboralService.getByNombre(nombre).get();
	        return new ResponseEntity<ExperienciaLaboral>(persona, HttpStatus.OK);
	    }
	  
	
	  @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody ExperienciaLaboralDto experienciaLaboralDto){
	        if(Strings.isBlank(experienciaLaboralDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(Strings.isBlank(experienciaLaboralDto.getInstitucion()))
	        	   return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
	      
	        ExperienciaLaboral experienciaLaboral = new ExperienciaLaboral  (experienciaLaboralDto.getNombre(), experienciaLaboralDto.getFechaDesde(), experienciaLaboralDto.getFechaHasta(), experienciaLaboralDto.getInstitucion(),experienciaLaboralDto.getInformacion() );
	        experienciaLaboralService.save(experienciaLaboral);
	        return new ResponseEntity(new Mensaje("experiencia laboral creado"), HttpStatus.OK);
	    }
	  
	 
	  @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ExperienciaLaboralDto experienciaLaboralDto){
	        if(!experienciaLaboralService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        if(experienciaLaboralService.existsByNombre(experienciaLaboralDto.getNombre()) && (experienciaLaboralService.getByNombre(experienciaLaboralDto.getNombre()).get().getId() != id))
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(Strings.isBlank(experienciaLaboralDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	     

	        ExperienciaLaboral experienciaLaboral = experienciaLaboralService.getOne(id).get();
	        experienciaLaboral.setNombre(experienciaLaboralDto.getNombre());
	        experienciaLaboral.setFechaDesde(experienciaLaboralDto.getFechaDesde());
	        experienciaLaboral.setFechaHasta(experienciaLaboralDto.getFechaHasta());
	        experienciaLaboral.setInstitucion(experienciaLaboralDto.getInstitucion());
	        experienciaLaboral.setInformacion(experienciaLaboralDto.getInformacion());
	        experienciaLaboralService.save(experienciaLaboral);
	        return new ResponseEntity(new Mensaje("persona actualizada"), HttpStatus.OK);
	    }
	  
	 
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")Long id){
	        if(!experienciaLaboralService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        experienciaLaboralService.delete(id);
	        return new ResponseEntity(new Mensaje("expriencia laboral eliminado"), HttpStatus.OK);
	    }
}