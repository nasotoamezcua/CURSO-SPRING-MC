package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaDAO {
	
	void crear(Persona persona);
	void update(Persona persona);
	List<Persona> listAll();
	Persona fnd(Integer id);
	void delete(Integer id);

}
