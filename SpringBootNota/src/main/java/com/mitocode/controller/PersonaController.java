package com.mitocode.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Controller
public class PersonaController {
	
	@Autowired
	private IPersonaService service;
	
	
	@RequestMapping(value = "/persona/listar" , method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<Persona> listarPersona(){
		return service.findAll();
	}
	
	@RequestMapping(value = "/persona/listar/xml" , method = RequestMethod.GET, produces = MediaType.APPLICATION_XML_VALUE)
	@ResponseBody
	public List<Persona> listarPersonaXMLL(){
		return service.findAll();
	}
	
	

}
