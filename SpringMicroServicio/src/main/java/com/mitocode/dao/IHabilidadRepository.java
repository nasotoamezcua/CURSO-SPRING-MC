package com.mitocode.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Habilidad;

@Repository
public interface IHabilidadRepository extends JpaRepository<Habilidad, Integer> {
	
	
	@Query("select new com.mitocode.model.Habilidad(h.id, h.nombre, h.experiencia) from habilidad h where h.persona.id = :idPersona")
	List<Habilidad> getHabilidadByPersonaId(@Param("idPersona") Integer id);

}
