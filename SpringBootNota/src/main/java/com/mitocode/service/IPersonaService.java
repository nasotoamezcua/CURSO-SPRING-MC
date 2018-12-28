package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaService {
	
	List<Persona> findAll();
	
	Persona create(Persona persona);
	
	Persona find(Integer id);
	
	Persona update(Persona persona);
	
	void delete(Integer id);

}
