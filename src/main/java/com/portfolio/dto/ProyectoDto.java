package com.portfolio.dto;




public class ProyectoDto {


	 private Long id;
	
	 private String nombre;
	
	 private String urlFoto;
	 
	 private String descripcion;
	
	
	public ProyectoDto() {
		super();
	}


	public ProyectoDto( String nombre, String urlFoto, String descripcion) {
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