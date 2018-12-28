package com.mitocode;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.PersonaServiceImpl;

public class App {
	
	public static void main(String[] args) {
		
//		IPersonaService service = new PersonaServiceImpl();
//		service.crear();
		
		ApplicationContext contex = new ClassPathXmlApplicationContext("beans.xml");
		IPersonaService service = contex.getBean("personaService", PersonaServiceImpl.class);
		Persona persona = contex.getBean("persona", Persona.class);
		
		service.crear();
		
		System.out.println(persona.getId() + "-" + persona.getNombres() + "-" + persona.getApellidos());
		
		((ConfigurableApplicationContext)contex).close();
	}

}
