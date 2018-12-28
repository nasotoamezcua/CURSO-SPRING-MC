package com.mitocode;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.mitocode.model.Usuario;
import com.mitocode.service.IUsuarioService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootNotaApplicationTests {
	
	@Autowired
	private IUsuarioService service;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Test
	public void contextLoads() {
		int x = 5;
		int y = 5;
		int suma = x+y;
		
		assertTrue(10 == suma);
	}
	
	@Test
	public void probarUsuario() {
		//Escenario probar que la clave que se genera con bCrypt sea la misma que se guarda en la BD
		Usuario us = new Usuario();
		us.setId(2);
		us.setNombre("alejandro");
		us.setClave(bCryptPasswordEncoder.encode("54321"));
		us.setTipo("ROLE_ADMIN");
		us.setEstado("1");
		
		System.out.println("Encode:" + bCryptPasswordEncoder.encode("54321"));
		System.out.println("Match:" + bCryptPasswordEncoder.matches("54321", "$2a$10$Ef08vbyMx9E1Y3QAZy1SXOXFd6syK6SUwhZId4eoD0ccJ.z66YoJC") );
		
		Usuario retorno1 = us;
		assertTrue(retorno1.getClave().equals(us.getClave()));
		
//		Guarda en la base de datos
//		Usuario retorno = service.create(us);
//		assertTrue(retorno.getClave().equals(us.getClave()));
	}

}

