package com.mitocode.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Curso;
import com.mitocode.model.Persona;

@RestController
public class DemoController {
	
	@GetMapping(value = "/", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Persona> mostrar() {
		
		Persona persona = new Persona();
		persona.setId(1);
		persona.setNombre("Nestor Alejandro");
		
		Curso curso = new Curso();
		curso.setId(1);
		curso.setNombre("Spring Avanzado");
		
		persona.setCurso(curso);
		
		return new ResponseEntity<Persona>(persona, HttpStatus.OK);
	}

}
