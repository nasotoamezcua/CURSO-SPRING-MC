package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Nota;

@Repository
public interface INotaRepo extends JpaRepository<Nota, Integer> {

}
