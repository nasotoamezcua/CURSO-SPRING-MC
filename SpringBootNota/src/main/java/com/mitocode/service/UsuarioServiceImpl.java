package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.IUsuarioRepo;
import com.mitocode.model.Usuario;

@Service
public class UsuarioServiceImpl  implements IUsuarioService{
	
	@Autowired
	private IUsuarioRepo dao;

	@Override
	public List<Usuario> findAll() {
		return dao.findAll();
	}

	@Override
	public Usuario create(Usuario usuario) {
		return dao.save(usuario);
	}

	@Override
	public Usuario find(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Usuario update(Usuario usuario) {
		return dao.save(usuario);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
