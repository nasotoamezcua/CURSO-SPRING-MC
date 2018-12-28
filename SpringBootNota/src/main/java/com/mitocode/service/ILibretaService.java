package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Libreta;

public interface ILibretaService {
	
	List<Libreta> findAll();
	
	Libreta create(Libreta libreta);
	
	Libreta find(Integer id);
	
	Libreta update(Libreta libreta);
	
	void delete(Integer id);

}
