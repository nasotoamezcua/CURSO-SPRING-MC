package com.mitocode.api;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.Habilidad;
import com.mitocode.service.IHabilidadService;

@RestController
@RequestMapping("/habilidad")
public class HabilidadController {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private IHabilidadService service;
	
	
	@GetMapping(path = "/listar/{idPersona}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Habilidad>> getAll(@PathVariable("idPersona") Integer id){
		logger.info("> getAll [Habilidad]");
		
		List<Habilidad> list = null;
		
		try {
			list = service.getHabilidadByPersonaId(id);
			
//			for(Habilidad h : list) {
//				if(h == null) {
//					h = new Habilidad();
//				}
//			}
//			
//			list.forEach((x) ->{
//				if(x == null) {
//					x = new Habilidad();
//				}
//			});
			
			if(list == null) {
				list = new ArrayList<Habilidad>();
			}
		}catch (Exception e) {
			logger.error("Unexpected Exception caught.", e);
			return new ResponseEntity<List<Habilidad>>(list, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		logger.info("< getAll [Habilidad]");
		return new ResponseEntity<List<Habilidad>>(list, HttpStatus.OK);
		
	}

}
