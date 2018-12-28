package com.mitocode;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

@Configuration
public class AppConfig {
	
	@Bean(name= "persona")
	public Persona persona() {
		return new Persona(1,"Nestor Alejandro", "Soto Amezcua");
//		return new Persona();
	}
	
	@Bean(name = "personaService")
	public IPersonaService personaService() {
		return new PersonaServiceImpl();
	}

}
