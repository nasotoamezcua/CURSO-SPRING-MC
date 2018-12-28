package com.mitocode.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaRepository;
import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Service
public class PersonaService implements IPersonaService {
	
	@Autowired
	private IPersonaRepository repo;

	@Override
	public List<Persona> findAll() {
		return repo.findAll();
	}

	@Override
	public Persona create(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public Persona find(Integer id) {
		return repo.findOne(id);
	}

	@Override
	public Persona update(Persona obj) {
		return repo.save(obj);
	}

	@Override
	public void delete(Integer id) {
		repo.delete(id);
	}

	@Override
	public Integer getUserIdByEmail(String correo) throws Exception {
		return repo.getUserIdByEmail(correo);
	}

}
