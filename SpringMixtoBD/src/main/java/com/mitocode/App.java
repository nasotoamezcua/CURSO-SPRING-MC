package com.mitocode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombres("Otro Mito 2");
		persona.setApellidos("Otro Code 2");
		
		IPersonaService service = context.getBean(PersonaServiceImpl.class);
		//service.crear(persona);
		service.delete(20);
		service.listAll().forEach(x -> System.out.println(x));
		
		((ConfigurableApplicationContext)context).close();
	}

}
