package com.mitocode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mitocode.dao.ILibretaRepo;
import com.mitocode.model.Libreta;

@Service
public class LibretaServiceImpl implements ILibretaService{
	
	@Autowired
	private ILibretaRepo dao;

	@Override
	public List<Libreta> findAll() {
		return dao.findAll();
	}

	@Override
	public Libreta create(Libreta libreta) {
		return dao.save(libreta);
	}

	@Override
	public Libreta find(Integer id) {
		return dao.findOne(id);
	}

	@Override
	public Libreta update(Libreta libreta) {
		return dao.save(libreta);
	}

	@Override
	public void delete(Integer id) {
		dao.delete(id);
	}

}
