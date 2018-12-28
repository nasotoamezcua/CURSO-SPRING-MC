package com.mitocode.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.ITelefonoDAO;
import com.mitocode.model.Telefono;

@Service
public class TelefonoService implements ITelefonoService {
	
	@Autowired
	private ITelefonoDAO dao;

	@Override
	public void registrar(Telefono telefono) throws Exception {
		dao.registrar(telefono);
	}

}
