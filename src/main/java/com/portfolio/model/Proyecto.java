package com.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="proyecto")
public class Proyecto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	@Column(name="nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name="urlFoto", length = 100, nullable = false)
	 private String urlFoto;
	
	@Column(name="descripcion", length = 100, nullable = false)
	 private String descripcion;
	
	
	public Proyecto() {
		super();
	}


	public Proyecto( String nombre, String urlFoto, String descripcion) {
		super();
		this.nombre = nombre;
		this.urlFoto = urlFoto;
		this.descripcion = descripcion;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getUrlFoto() {
		return urlFoto;
	}


	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


}