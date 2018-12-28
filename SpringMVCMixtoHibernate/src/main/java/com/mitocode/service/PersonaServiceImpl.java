package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IPersonaDAO;
import com.mitocode.model.Persona;

@Service
public class PersonaServiceImpl implements IPersonaService {
	
	@Autowired
	IPersonaDAO dao;

	@Override
	public void registar(Persona per) throws Exception {
		dao.registar(per);
	}

	@Override
	public void modificar(Persona per) throws Exception {
		dao.modificar(per);
	}

	@Override
	public void eliminar(Persona per) throws Exception {
		dao.eliminar(per);
	}

	@Override
	public List<Persona> listarTodos() throws Exception {
		return dao.listarTodos();
	}

	@Override
	public Persona listarPorId(int id) throws Exception {
		return dao.listarPorId(id);
	}

}
