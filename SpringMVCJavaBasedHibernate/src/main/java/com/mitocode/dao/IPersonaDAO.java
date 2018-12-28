package com.mitocode.dao;

import java.util.List;

import com.mitocode.model.Persona;

public interface IPersonaDAO {
	
	void registar(Persona per) throws Exception;
	
	void modificar(Persona per) throws Exception;
	
	void eliminar(Persona per) throws Exception;
	
	List<Persona> listarTodos() throws Exception;
	
	Persona listarPorId(int id) throws Exception;

}
