package com.portfolio.dto;

import javax.persistence.Column;

public class ExperienciaLaboralDto {
private Long id;
	
	private String nombre;
	
	
	private String fechaDesde;
	
	
	 private String fechaHasta;
	
	
	private String institucion;
	
	
	private String informacion;

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

	public String getFechaDesde() {
		return fechaDesde;
	}

	public void setFechaDesde(String fechaDesde) {
		this.fechaDesde = fechaDesde;
	}
	
	public String getFechaHasta() {
		return fechaHasta;
	}

	public void setFechaHasta(String fechaHasta) {
		this.fechaHasta = fechaHasta;
	}

	public String getInstitucion() {
		return institucion;
	}

	public void setInstitucion(String institucion) {
		this.institucion = institucion;
	}

	public String getInformacion() {
		return informacion;
	}

	public void setInformacion(String informacion) {
		this.informacion = informacion;
	}


	public ExperienciaLaboralDto(String nombre, String fechaDesde, String fechaHasta, String institucion, String informacion) {
		super();
		this.nombre = nombre;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.institucion = institucion;
		this.informacion = informacion;
	}

	public ExperienciaLaboralDto() {
		super();
	}
}