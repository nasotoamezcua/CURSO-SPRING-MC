package com.mitocode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/persona")
public class PersonaController {
	
	@RequestMapping(value = "/saludar", method = RequestMethod.GET)
	public String saludar(ModelMap model) {
		model.addAttribute("nombres","Nestor Alejandro");
		model.addAttribute("apellidos","Soto Amezcua");
		
		return "persona";
		
	}
	
	@RequestMapping(value = "/enviar", method = RequestMethod.POST)
	public String enviar(ModelMap model) {
		model.addAttribute("nombres","Nestor Alejandro");
		model.addAttribute("apellidos","Soto Amezcua");
		
		return "persona";
		
	}
	
	@RequestMapping(value = "/prueba", method = RequestMethod.GET)
	public ModelAndView prueba() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("persona");
		mv.addObject("nombres","Nestor Alejandro");
		mv.addObject("apellidos","Soto Amezcua");
		return mv;
	}

}
