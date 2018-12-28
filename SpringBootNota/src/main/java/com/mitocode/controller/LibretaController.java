package com.mitocode.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mitocode.model.Libreta;
import com.mitocode.model.Nota;
import com.mitocode.service.ILibretaService;

@Controller
public class LibretaController {
	
	@Autowired
	ILibretaService service;
	
	@RequestMapping(value = "/libreta/registrar" , method = RequestMethod.POST, 
			consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public String registrar(@RequestBody Libreta libreta) {
		
		for(Nota n:libreta.getNotas()) {
			n.setLibreta(libreta);
		}
		
		Libreta lib = service.create(libreta);
		return lib != null ? "1" : "0";
	}

}
