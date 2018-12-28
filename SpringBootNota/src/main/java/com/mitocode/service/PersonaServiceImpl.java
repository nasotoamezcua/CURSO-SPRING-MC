package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaRepo;
import com.mitocode.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaRepo dao;

	@Override
	public List<Persona> findAll() {
		return dao.findAll();
	}

	@Override
	public Persona create(Persona persona) {
		return dao.save(persona);
	}

	@Override
	public Persona find(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Persona update(Persona persona) {
		return dao.save(persona);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);	
	}

}
