package com.mitocode.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Repository;

@Repository
public class ColumnaDAOImpl implements IColumnaDAO{

	@Async
	@Override
	public CompletableFuture<List<String>> getColumnasAsync() {
		List<String> lista = new ArrayList<>();
		lista.add("COL1");
		lista.add("COL2");
		lista.add("COL3");
		lista.add("COL4");
		lista.add("COL5");
		
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return CompletableFuture.completedFuture(lista);
	}

	@Override
	public List<String> getColumnas() {
		List<String> lista = new ArrayList<>();
		lista.add("COL1");
		lista.add("COL2");
		lista.add("COL3");
		lista.add("COL4");
		lista.add("COL5");
		
		try {
			Thread.sleep(2000);
		}catch (InterruptedException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
