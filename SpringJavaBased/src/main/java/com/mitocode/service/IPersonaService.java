package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaService {
	
	void crear(Persona persona);
	void update(Persona persona);
	List<Persona> listAll();
	Persona fnd(Integer id);
	void delete(Integer id);

}
