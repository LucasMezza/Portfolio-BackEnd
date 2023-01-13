package com.portfolio.dto;

public class PersonDto {

	private String nombre;
	private String password;
	private String urlFoto;
	private String sobreMi;
	
	public PersonDto(String nombre, String password, String urlFoto,
			String sobreMi) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.urlFoto = urlFoto;
		this.sobreMi = sobreMi;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUrlFoto() {
		return urlFoto;
	}

	public void setUrlFoto(String urlFoto) {
		this.urlFoto = urlFoto;
	}

	public String getSobreMi() {
		return sobreMi;
	}

	public void setSobreMi(String sobreMi) {
		this.sobreMi = sobreMi;
	}
	
	
}
