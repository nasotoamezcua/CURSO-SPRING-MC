package com.mitocode;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.security.oauth2.client.OAuth2ClientContext;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class AuthServer {

	public static void main(String[] args) {
		SpringApplication.run(AuthServer.class, args);
	}

	@Autowired
	private OAuth2ClientContext context;


	@GetMapping("/access_token")
	public String getToken() {
		String token = context.getAccessToken().getValue();
		System.out.println("Token: " + token);
		return token;
	}
	
	@GetMapping("/user")
	public Principal getUser(Principal user) {
		return user;
	}
	
}