package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.INotaRepo;
import com.mitocode.model.Nota;

@Service
public class NotaServiceImpl implements INotaService{
	
	@Autowired
	private INotaRepo dao;

	@Override
	public List<Nota> findAll() {
		return dao.findAll();
	}

	@Override
	public Nota create(Nota nota) {
		return dao.save(nota);
	}

	@Override
	public Nota find(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Nota update(Nota nota) {
		return dao.save(nota);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
