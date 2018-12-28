package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	private IPersonaDAO dao;

	@Override
	public void crear(Persona persona) {
		dao.crear(persona);
	}

	@Override
	public void update(Persona persona) {
		dao.update(persona);
		
	}

	@Override
	public List<Persona> listAll() {
		return dao.listAll();
	}

	@Override
	public Persona fnd(Integer id) {
		return dao.fnd(id);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
