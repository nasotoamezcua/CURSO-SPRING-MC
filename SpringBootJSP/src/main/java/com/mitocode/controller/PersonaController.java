package com.mitocode.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PersonaController {
	
	@RequestMapping("/persona")
	public String saludar(@RequestParam(value = "nombre", required = false, defaultValue = "MitoCode") String nombre, 
			Model model) {
		
		model.addAttribute("nombre", nombre);
		
		return "persona";
	}
	
	
	@RequestMapping("/")
	public String irIndex() {
		return "index";
	}

}
