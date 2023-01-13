package com.portfolio.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.portfolio.model.Person;
import com.portfolio.security.model.UsuarioPrincipal;

@Service
public class PersonDetailsServiceImpl implements UserDetailsService{

	@Autowired
	PersonSecurityService usuarioService;
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		   Person person = usuarioService.getByNombre(nombre).get();
	       return UsuarioPrincipal.build(person);
	}

}
