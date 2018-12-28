package com.mitocode;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		AbstractApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombres("Otro Mito");
		persona.setApellidos("Otro Code");
		
		IPersonaService service = context.getBean(PersonaServiceImpl.class);
		service.crear(persona);
		//service.delete(20);
		service.listAll().forEach(x -> System.out.println(x));
		
		context.close();
	}

}
