package com.portfolio.controller;

import java.util.List;

import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
import com.portfolio.dto.PersonDto;
import com.portfolio.model.Person;
import com.portfolio.service.PersonaService;

@RestController
@RequestMapping("/persona")
@CrossOrigin(origins = "*")
public class PersonController {
	@Autowired
	 PersonaService personService;
	 
	 @GetMapping("/lista") 
	    public ResponseEntity<List<Person>> list(){
	        List<Person> list = personService.list();
	        return new ResponseEntity<List<Person>>(list, HttpStatus.OK);
	    }
	 
	  @GetMapping("/detail/{id}")
	    public ResponseEntity<Object> getById(@PathVariable("id") Long id){
	        if(!personService.existsById(id))
	            return new ResponseEntity<Object>(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        Person persona = personService.getOne(id).get();
	        return new ResponseEntity<Object>(persona, HttpStatus.OK);
	    }
	  
	  @GetMapping("/detailname/{nombre}")
	    public ResponseEntity<Person> getByNombre(@PathVariable("nombre") String nombre){
	        if(!personService.existsByNombre(nombre))
	            return new ResponseEntity<Person>(HttpStatus.NOT_FOUND);
	        Person persona = personService.getByNombre(nombre).get();
	        return new ResponseEntity<Person>(persona, HttpStatus.OK);
	    }
	  
	  
	  @PostMapping("/create")
	    public ResponseEntity<?> create(@RequestBody PersonDto personDto){
	        if(Strings.isBlank(personDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);
	        if(Strings.isBlank(personDto.getNombre()))
	        	return new ResponseEntity(new Mensaje("La constraseña es obligatoria"), HttpStatus.BAD_REQUEST);
	        Person persona = new Person(personDto.getNombre(), personDto.getPassword(), personDto.getUrlFoto(), personDto.getSobreMi());
	        personService.save(persona);
	        return new ResponseEntity(new Mensaje("Persona creado"), HttpStatus.OK);
	    }
	  
	  
	  @PutMapping("/update/{id}")
	    public ResponseEntity<?> update(@PathVariable("id")Long id, @RequestBody PersonDto personDto){
	        if(!personService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        if(personService.existsByNombre(personDto.getNombre()) && personService.getByNombre(personDto.getNombre()).get().getId() != id)
	            return new ResponseEntity(new Mensaje("ese nombre ya existe"), HttpStatus.BAD_REQUEST);
	        if(Strings.isBlank(personDto.getNombre()))
	            return new ResponseEntity(new Mensaje("el nombre es obligatorio"), HttpStatus.BAD_REQUEST);

	        Person persona = personService.getOne(id).get();
	        persona.setNombre(personDto.getNombre());
	        persona.setPassword(personDto.getPassword());
	        persona.setUrlFoto(personDto.getUrlFoto());
	        persona.setSobreMi(personDto.getSobreMi());
	        personService.save(persona);
	        return new ResponseEntity(new Mensaje("Persona actualizado"), HttpStatus.OK);
	    }
	  
	 
	  @DeleteMapping("/delete/{id}")
	    public ResponseEntity<?> delete(@PathVariable("id")Long id){
	        if(!personService.existsById(id))
	            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
	        personService.delete(id);
	        return new ResponseEntity(new Mensaje("Persona eliminado"), HttpStatus.OK);
	    }
	
}
