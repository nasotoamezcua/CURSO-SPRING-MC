package com.mitocode;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;

	@Autowired
	public void configure(AuthenticationManagerBuilder auth) throws Exception {

		auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(bCryptPasswordEncoder)
				.usersByUsernameQuery(
						"select * from (select nombre as username, clave as password, estado as enabled from usuario) as users where username = ?")
				.authoritiesByUsernameQuery(
						"select * from (select nombre as username, tipo as AUTHORITY from usuario) as authorities where username = ? ");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests()
		.antMatchers("/nota**").access("hasRole('ROLE_ADMIN')")
		.antMatchers("/nota**").access("hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')")
		.and().formLogin()
				.loginPage("/login")
					.loginProcessingUrl("/j_spring_security_check")
					.defaultSuccessUrl("/nota")
					.failureUrl("/login?error")
					.usernameParameter("usuario")
					.passwordParameter("clave")
						.and().logout()
						.logoutSuccessUrl("/login?logout")
						.logoutUrl("/j_spring_security_logout")
							.and().exceptionHandling().accessDeniedPage("/403")
								.and().csrf();// .disable();
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}

	
	

}
