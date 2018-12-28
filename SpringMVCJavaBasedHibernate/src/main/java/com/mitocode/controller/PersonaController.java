package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.mitocode.model.Persona;
import com.mitocode.service.IPersonaService;

@Controller
public class PersonaController {
	
	@Autowired
	IPersonaService service;
	
	@RequestMapping(value = "/irRegistrar", method = RequestMethod.GET)
	public ModelAndView redireccion() throws Exception{
		return new ModelAndView("persona", "command",new Persona());
	}
	
	@RequestMapping(value = "/personas", method = RequestMethod.GET)
	public ModelAndView personas()  throws Exception{
		return new ModelAndView("listaPersona", "personas", service.listarTodos());
	}
	
	@RequestMapping(value = "/irEditar", method = RequestMethod.GET)
	public ModelAndView irEditar(@RequestParam(value="id") String id) throws Exception{
		return new ModelAndView("persona", "command", service.listarPorId(Integer.parseInt(id)));
	}
	
	@RequestMapping(value = "/remover", method = RequestMethod.GET)
	public ModelAndView remover(@RequestParam(value = "id") String id) throws Exception{
		if(id != null && Integer.parseInt(id) >0) {
			Persona persona = service.listarPorId(Integer.parseInt(id));
			if(persona != null) {
				service.eliminar(persona);
			}
		}
		
		return new ModelAndView("listaPersona", "personas", service.listarTodos());
	}
	
	
	@RequestMapping(value = "registrar", method = RequestMethod.POST)
	public ModelAndView registrar(Persona persona, ModelMap model) throws Exception{
		
		try {
			if(persona.getId() == 0) {
				service.registar(persona);
			}else {
				service.modificar(persona);
			}
			
		}catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		return new ModelAndView("listaPersona", "personas", service.listarTodos());
		
	}
	
	

}
