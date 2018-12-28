package com.mitocode.model;

import org.springframework.beans.factory.annotation.Value;

public class Persona {
	
	@Value("1")
	private int id;
	@Value("Nestor Alejandro")
	private String nombres;
	@Value("Soto Amezcua")
	private String apellidos;
	
	public Persona() {}
	
	public Persona(int id, String nombres, String apellidos) {
		super();
		this.id = id;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	
	

}
