package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mitocode.model.Telefono;
import com.mitocode.service.IPersonaService;
import com.mitocode.service.ITelefonoService;

@Controller
public class TelefonoController {
	
	@Autowired
	private ITelefonoService telefonoService;
	
	@Autowired
	private IPersonaService personaService;
	
	@RequestMapping(value = "/irTelefono", method = RequestMethod.GET)
	public ModelAndView redireccion() throws Exception{
		ModelAndView model = new ModelAndView("telefono");
		model.addObject("personas", personaService.listarTodos());
		model.addObject("command", new Telefono());
		return model;
	}
	
	@RequestMapping(value = "/registrarTelefono" , method = RequestMethod.POST)
	public ModelAndView registrar(Telefono telefono, ModelMap model) throws Exception{
		//ModelMap model, @ModelAttribute Telefono telefono
		telefonoService.registrar(telefono);
		return new ModelAndView("listaPersona", "personas", personaService.listarTodos());
	}

}
