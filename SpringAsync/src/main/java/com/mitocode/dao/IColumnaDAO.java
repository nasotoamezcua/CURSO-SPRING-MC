package com.mitocode.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IColumnaDAO {
	
	CompletableFuture<List<String>> getColumnasAsync();
	
	List<String> getColumnas();
	

}
