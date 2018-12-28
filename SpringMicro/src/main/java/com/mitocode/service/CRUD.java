package com.mitocode.service;

import java.util.List;

public interface CRUD<T> {

	List<T> findAll();

	T create(T obj);

	T find(Integer id);

	T update(T obj);

	void delete(Integer id);
}
