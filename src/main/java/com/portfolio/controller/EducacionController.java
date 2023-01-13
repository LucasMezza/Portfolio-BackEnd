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

import com.portfolio.dto.EducacionDto;
import com.portfolio.dto.Mensaje;
import com.portfolio.model.Educacion;
import com.portfolio.service.EducacionService;


@RestController
@RequestMapping("/educacion")
@CrossOrigin(origins = "*")
public class EducacionController {

	 @Autowired
	 EducacionService educacionService;
	 
	 @GetMapping("/lista") 
	    public ResponseEntity<List<Educacion>> list(){
	        List<Educacion> list = educacionService.list();
	        return new ResponseEntity<List<Educacion>>(list, HttpStatus.OK);
	    }
	 
	  @GetMapping("/detail/{id}")
	    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
	        if(!educacionService.existsById(id))
	            return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Educacion educacion = educacionService.getOne(id).get();
	        return new ResponseEntity<Object>(educacion, HttpStatus.OK);
	    }
	  
	  @GetMapping("/detailname/{nombre}")
	    public ResponseEntity<Educacion> getByNombre(@PathVariable("nombre") String nombre){
	        if(!educacionService.existsByNombre(nombre))
	            return new ResponseEntity<Educacion>(HttpStatus.NOT_FOUND);
	        Educacion educacion = educacionService.getByNombre(nombre).get();
	        return new ResponseEntity<Educacion>(educacion, HttpStatus.OK);
	    }
	  
	
	  @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody EducacionDto educacionDto){
	        if(Strings.isBlank(educacionDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(Strings.isBlank(educacionDto.getInstitucion()))
	        	   return new ResponseEntity(new Mensaje("el apellido es obligatorio"), HttpStatus.BAD_REQUEST);
	      
	        Educacion educacion = new Educacion (educacionDto.getNombre(), educacionDto.getFechaDesde(),educacionDto.getFechaHasta(), educacionDto.getInstitucion(),educacionDto.getInformacion() );
	        educacionService.save(educacion);
	        return new ResponseEntity(new Mensaje("persona creado"), HttpStatus.OK);
	    }
	  
	  @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody EducacionDto educacionDto){
	        if(!educacionService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        if(educacionService.existsByNombre(educacionDto.getNombre()) && (educacionService.getByNombre(educacionDto.getNombre()).get().getId() != id))
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(Strings.isBlank(educacionDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	     

	        Educacion educacion = educacionService.getOne(id).get();
	        educacion.setNombre(educacionDto.getNombre());
	        educacion.setFechaDesde(educacionDto.getFechaDesde());
	        educacion.setFechaHasta(educacionDto.getFechaHasta());
	        educacion.setInstitucion(educacionDto.getInstitucion());
	        educacion.setInformacion(educacionDto.getInformacion());
			educacionService.save(educacion);
	        return new ResponseEntity(new Mensaje("educacion actualizada"), HttpStatus.OK);
	    }
	  
	 
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")Long id){
	        if(!educacionService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        educacionService.delete(id);
	        return new ResponseEntity(new Mensaje("educacion eliminado"), HttpStatus.OK);
	    }
}