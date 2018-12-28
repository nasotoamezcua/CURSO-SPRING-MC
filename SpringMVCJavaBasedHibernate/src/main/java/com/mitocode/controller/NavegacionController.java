package com.mitocode.controller;

import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NavegacionController {
	
	@RequestMapping(value = {"/","/principal**"}, method = RequestMethod.GET)
	public ModelAndView defaultPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("titulo","Spring XML + Hibernate");
		model.setViewName("login");
		
		return model;
	}
	
	@RequestMapping(value = "/admin**", method = RequestMethod.GET)
	public ModelAndView adminPage() {
		
		ModelAndView model = new ModelAndView();
		model.addObject("titulo", "Spring Security XML + Hibernate");
		model.addObject("mensaje", "Página disponible solo para el administrador!");
		model.setViewName("/admin/admin");
		
		return model;
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login(@RequestParam(value = "error", required = false) String error,
			@RequestParam(value = "logout", required = false) String logout) {

		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Crendenciales incorrectas!");
		}

		if (logout != null) {
			model.addObject("msg", "Sesión cerrada correctamente.");
		}
		model.setViewName("login");

	return model;
	}
	
	@RequestMapping(value = "/403", method = RequestMethod.GET)
	public ModelAndView accesssDenied() {

		ModelAndView model = new ModelAndView();

		// verifica si el usuario esta logeado
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		if (!(auth instanceof AnonymousAuthenticationToken)) {
			UserDetails userDetail = (UserDetails) auth.getPrincipal();
			model.addObject("usuario", userDetail.getUsername());
		}
		
		model.setViewName("403");
		return model;
	}

}
