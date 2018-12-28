package com.mitocode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		IPersonaService service = context.getBean("personaService",PersonaServiceImpl.class);
		Persona persona = context.getBean("persona", Persona.class);
		
		service.crear();
		
		System.out.println(persona.getId() + "-" + persona.getNombres() + "-" + persona.getApellidos());
		
		context.close();
		
	}

}
