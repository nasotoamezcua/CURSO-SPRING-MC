package com.mitocode.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Persona;

@Repository
public class PersonaDAOImpl  extends JdbcDaoSupport implements IPersonaDAO{
	
	/*
	@Autowired
	private DataSource dataSource;
	*/
	
	@Autowired
	public PersonaDAOImpl(DataSource dataSource) {
		setDataSource(dataSource);
	}

	@Override
	public void crear(Persona persona) {
		
		String sql = "INSERT INTO persona(nombres,apellidos) VALUES(?,?)";
		
		/*
		try(Connection cx = dataSource.getConnection()) {
			PreparedStatement ps = cx.prepareStatement(sql);
			ps.setString(1, persona.getNombres());
			ps.setString(2, persona.getApellidos());
			ps.executeUpdate();
			ps.close();
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		*/
		
		getJdbcTemplate().update(sql, new Object[] {persona.getNombres(), persona.getApellidos()});
		
	}

	@Override
	public void update(Persona persona) {
		String sql = "UPDATE persona SET nombres = ?, apellidos = ? WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[] {persona.getNombres(), persona.getApellidos(), persona.getId()});
		
	}

	@Override
	public List<Persona> listAll() {
		String sql = "SELECT id,nombres, apellidos FROM persona ORDER BY nombres, apellidos";
		return getJdbcTemplate().query(sql, new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Override
	public Persona fnd(Integer id) {
		String sql = "SELECT id,nombres, apellidos FROM persona WHERE id = ?";
		return getJdbcTemplate().queryForObject(sql, new Object[] {id}, new BeanPropertyRowMapper<Persona>(Persona.class));
	}

	@Transactional
	@Override
	public void delete(Integer id) {
		String sql = "DELETE FROM persona WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] {id});
		
		sql = "UPDATE persona SET nombres = ?, apellidos = ? WHERE id = ?";
		
		getJdbcTemplate().update(sql, new Object[] {null, null, id});
	}

}
