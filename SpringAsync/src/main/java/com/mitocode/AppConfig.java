package com.mitocode;

import java.util.concurrent.Executor;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;


@SpringBootApplication
@EnableAsync
public class AppConfig {
	
	@Bean //Executor es un pool de hilos para poder procesar de manera asincrona
	public Executor asyncExecutor() {
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(12);  	//inicia con 3 hilos
		executor.setMaxPoolSize(12); 	//solo puede tener un maximo de 12 hilos
		executor.setQueueCapacity(500);	//si los 3 estan ocupados hasta un maximo de 500 procesos pueden hacer cola	hasta que sean procesados
		executor.initialize();
		return executor;
	}
	
	public static void main(String[] args) {
		SpringApplication.run(AppConfig.class, args).close(); //es como un System.exit
	}

}
