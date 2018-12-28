package com.mitocode.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.Libreta;

@Repository
public interface ILibretaRepo extends JpaRepository<Libreta, Integer> {

}
