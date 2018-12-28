package com.mitocode.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public class FilaDAOImpl implements IFilaDAO {
	
	@Async
	@Override
	public CompletableFuture<List<String>> getFilasAsync() {
		List<String> lista = new ArrayList<>();
		lista.add("FIL1");
		lista.add("FIL2");
		lista.add("FIL3");
		lista.add("FIL4");
		lista.add("FIL5");
		
		try {
			Thread.sleep(2000); //simular 2 seg
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(lista);
	}

	@Override
	public List<String> getFilas() {
		List<String> lista = new ArrayList<>();
		lista.add("FIL1");
		lista.add("FIL2");
		lista.add("FIL3");
		lista.add("FIL4");
		lista.add("FIL5");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return lista;
	}
}
