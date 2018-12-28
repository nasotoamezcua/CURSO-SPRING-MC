package com.mitocode.dao;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Telefono;

@Repository
@Transactional
public class TelefonoDAOImpl extends AbstractDAO implements ITelefonoDAO {

	@Override
	public void registrar(Telefono telefono) throws Exception {
		persist(telefono);
		
	}

}
