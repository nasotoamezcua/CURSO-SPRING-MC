package com.mitocode.dao;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public interface IFilaDAO {
	
	//con procesamiento asincrono, devuelve una List<String> englobadas en un concepto future (una promesa a futuro)
	CompletableFuture<List<String>> getFilasAsync();
	//sin procesamiento asincrono
	List<String> getFilas();	

}
