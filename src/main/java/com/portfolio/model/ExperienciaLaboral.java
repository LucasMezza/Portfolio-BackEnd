package com.portfolio.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="experienciaLaboral")
public class ExperienciaLaboral {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Long id;
	@Column(name="nombre", length = 50, nullable = false)
	private String nombre;
	
	@Column(name="fechaDesde", length = 50, nullable = false)
	 private String fechaDesde;
	
	@Column(name="fechaHasta", length = 50, nullable = false)
	 private String fechaHasta;
	
	@Column(name="institucion", length = 50, nullable = false)
	private String institucion;
	
	@Column(name="informacion", length = 400, nullable = false)
	private String informacion;

	public ExperienciaLaboral( String nombre, String fechaDesde, String fechaHasta, String institucion, String informacion) {
		super();
		this.nombre = nombre;
		this.fechaDesde = fechaDesde;
		this.fechaHasta = fechaHasta;
		this.institucion = institucion;
		this.informacion = informacion;
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

	public ExperienciaLaboral() {
		super();
	}
}
