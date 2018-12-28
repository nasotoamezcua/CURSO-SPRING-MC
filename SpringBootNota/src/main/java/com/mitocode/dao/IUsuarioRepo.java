package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Usuario;

@Repository
public interface IUsuarioRepo extends JpaRepository<Usuario, Integer>{

}
