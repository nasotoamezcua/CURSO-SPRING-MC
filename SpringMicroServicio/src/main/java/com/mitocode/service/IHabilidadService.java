package com.mitocode.service;

import java.util.List;

import com.mitocode.model.Habilidad;

public interface IHabilidadService extends CRUD<Habilidad> {
	
	List<Habilidad> getHabilidadByPersonaId(Integer id);
	
	

}
