package com.ais.oauth.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;

@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfig extends AuthorizationServerConfigurerAdapter {

	@Autowired
	private AuthenticationManager authenticationManager;
	
	/** 
	 * Configurando o gerenciador de autentica��o e servi�os de token.
	 * @param endpoint
	 */
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) {
		endpoints.authenticationManager(authenticationManager);
	}
	
	/**
	 * Configurando os clientes com id do cliente, senha, escopo de acesso, tipo de concess�o e tempo de expira��o do token de acesso.
	 * @param clients
	 * @throws Exception
	 */
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
			.withClient("client")
			.secret("password")
			.scopes("read", "write")
			.authorizedGrantTypes("password")
			.accessTokenValiditySeconds(60)
			.and()
			.withClient("client2")
			.secret("password2")
			.scopes("read")
			.authorizedGrantTypes("client_credentials")
			.accessTokenValiditySeconds(60);

	}
	
	/**
	 * Configurando as restri��es de seguran�a da verifica��o do token de acesso.
	 * @param auth.
	 */
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer auth) {
		auth.checkTokenAccess("isAuthenticated()");
	}
}
