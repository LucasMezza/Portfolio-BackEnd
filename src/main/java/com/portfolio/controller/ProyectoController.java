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

import com.portfolio.dto.Mensaje;
import com.portfolio.dto.ProyectoDto;
import com.portfolio.model.Proyecto;
import com.portfolio.service.ProyectoService;

@RestController
@RequestMapping("/proyecto")
@CrossOrigin(origins = "*")
public class ProyectoController {


	 @Autowired
	 ProyectoService proyectoService;
	 
	 @GetMapping("/lista") 
	    public ResponseEntity<List<Proyecto>> list(){
	        List<Proyecto> list = proyectoService.list();
	        return new ResponseEntity<List<Proyecto>>(list, HttpStatus.OK);
	    }
	 
	  @GetMapping("/detail/{id}")
	    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
	        if(!proyectoService.existsById(id))
	            return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Proyecto proyecto = proyectoService.getOne(id).get();
	        return new ResponseEntity<Object>(proyecto, HttpStatus.OK);
	    }
	  
	  @GetMapping("/detailname/{nombre}")
	    public ResponseEntity<Proyecto> getByNombre(@PathVariable("nombre") String nombre){
	        if(!proyectoService.existsByNombre(nombre))
	            return new ResponseEntity<Proyecto>(HttpStatus.NOT_FOUND);
	        Proyecto proyecto = proyectoService.getByNombre(nombre).get();
	        return new ResponseEntity<Proyecto>(proyecto, HttpStatus.OK);
	    }
	  
	
	  @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody ProyectoDto proyectoDto){
	        if(Strings.isBlank(proyectoDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	      
	        Proyecto proyecto = new Proyecto (proyectoDto.getNombre(), proyectoDto.getUrlFoto(), proyectoDto.getDescripcion());
	        proyectoService.save(proyecto);
	        return new ResponseEntity(new Mensaje("proyecto creado"), HttpStatus.OK);
	    }
	  
	  @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody ProyectoDto proyectoDto){
	        if(!proyectoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        if(proyectoService.existsByNombre(proyectoDto.getNombre()) && (proyectoService.getByNombre(proyectoDto.getNombre()).get().getId() != id))
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(Strings.isBlank(proyectoDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	     

	        Proyecto proyecto = proyectoService.getOne(id).get();
	        proyecto.setNombre(proyectoDto.getNombre());
	        proyecto.setUrlFoto(proyectoDto.getUrlFoto());
	        proyecto.setDescripcion(proyectoDto.getDescripcion());
			proyectoService.save(proyecto);
	        return new ResponseEntity(new Mensaje("proyecto actualizada"), HttpStatus.OK);
	    }
	  
	 
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")Long id){
	        if(!proyectoService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        proyectoService.delete(id);
	        return new ResponseEntity(new Mensaje("proyecto eliminado"), HttpStatus.OK);
	    }
}