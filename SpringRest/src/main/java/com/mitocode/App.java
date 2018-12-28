package com.mitocode;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.client.RestTemplate;

import com.mitocode.model.Quote;

public class App {
	
	private static final Logger log = LoggerFactory.getLogger(App.class);
	
	public static void main(String[] args) {
		
		RestTemplate restTemplate = new RestTemplate();
		
		Quote q = restTemplate.getForObject("http://gturnquist-quoters.cfapps.io/api/random", Quote.class);
		
		log.info(q.toString());
		log.info(q.getType());
		log.info("" + q.getValue().getId());
		log.info(q.getValue().getQuote());
	}
	
	

}
