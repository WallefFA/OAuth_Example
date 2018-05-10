package com.ais.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
@EnableWebSecurity
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {
	
	/**
	 * Configurando o Proprietário do Recurso com username, senha e função.
	 * @param manager
	 * @throws Exception
	 */
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder manager) throws Exception {
		
		manager.inMemoryAuthentication()
			.withUser("user")
			.password("password")
			.roles("USER");
	}
	
	/**
	 * Configurando restrições de acesso aos recursos.
	 * @param http
	 * @throws Exception
	 */
	
	@Override
	public void configure (HttpSecurity http) throws Exception {
	
		http.authorizeRequests()
			.anyRequest()
			.authenticated();	
	}
}
