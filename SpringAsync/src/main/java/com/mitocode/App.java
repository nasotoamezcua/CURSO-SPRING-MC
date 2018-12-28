package com.mitocode;

import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.mitocode.dao.IColumnaDAO;
import com.mitocode.dao.IFilaDAO;

@Component
public class App implements CommandLineRunner {
	
		//Adaptado de
		//https://spring.io/guides/gs/async-method/
		
		private static final Logger logger = LoggerFactory.getLogger(App.class);

		@Autowired
		private IFilaDAO filaDAO;

		@Autowired
		private IColumnaDAO columnaDAO;

		
		
		//metodo de run de la interfaz CommandLineRunner, para ejecutar aplicaciones en consola con Spring Boot
		@Override
		public void run(String... arg0) throws Exception {
			long inicio = System.currentTimeMillis();
			
			//con hilos
			CompletableFuture<List<String>> future1 = filaDAO.getFilasAsync();		 //voy por la promesa 1
			CompletableFuture<List<String>> future2 = columnaDAO.getColumnasAsync(); //voy por la promesa 2
			//CompletableFuture<List<String>> future3 = columnaDAO.getColumnasAsync(); //voy por la promesa 3

			//esperar que todas esten hechas
			CompletableFuture.allOf(future1, future2).join();
			//CompletableFuture.allOf(future1, future2, future3).join();

			logger.info("Tiempo transcurrido: " + (System.currentTimeMillis() - inicio)/1000);
			logger.info("--> " + future1.get());
			logger.info("--> " + future2.get());
			//logger.info("--> " + future3.get());
			
			//sin hilos
			filaDAO.getFilas();
			columnaDAO.getColumnas();
			logger.info("Tiempo transcurrido: " + (System.currentTimeMillis() - inicio)/1000);
			
		}


}
