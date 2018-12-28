package com.mitocode.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mitocode.model.Persona;

@Transactional
@Repository
public class PersonaDAOImpl extends AbstractDAO implements IPersonaDAO{

	@Override
	public void registar(Persona per) throws Exception {
		this.persist(per);
	}

	@Override
	public void modificar(Persona per) throws Exception {
		this.update(per);
	}

	@Override
	public void eliminar(Persona per) throws Exception {
		this.delete(per);
	}

	@Override
	public List<Persona> listarTodos() throws Exception {
		Criteria criteria = getSession().createCriteria(Persona.class);
		return (List<Persona>)criteria.list();
	}

	@Override
	public Persona listarPorId(int id) throws Exception {
		
		List<Persona> lista;
		
		String sql = "FROM Persona WHERE id = :id";
		
		Query query = getSession().createQuery(sql);
		query.setParameter("id", id);
		
		lista = query.list();
		
		Persona per = ((lista != null && !lista.isEmpty()) ? lista.get(0) : new Persona());
		return per;
	}

}
