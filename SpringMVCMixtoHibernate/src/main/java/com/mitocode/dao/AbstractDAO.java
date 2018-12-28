package com.mitocode.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

public abstract class AbstractDAO {
	
	@Autowired
	private SessionFactory sessionFactoty;
	
	
	protected Session getSession() {
		return sessionFactoty.getCurrentSession();
	}
	
	public void persist(Object entidad) {
		getSession().persist(entidad);
	}
	
	public void update(Object entidad) {
		getSession().update(entidad);
	}
	
	public void delete(Object entidad) {
		getSession().delete(entidad);
	}
}
