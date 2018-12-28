package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Nota;

public interface INotaService {
	
	List<Nota> findAll();
	
	Nota create(Nota nota);
	
	Nota find(Integer id);
	
	Nota update(Nota nota);
	
	void delete(Integer id);

}
