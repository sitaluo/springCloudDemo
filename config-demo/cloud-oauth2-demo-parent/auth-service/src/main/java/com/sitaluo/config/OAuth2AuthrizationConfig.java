package com.sitaluo.config;


import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.jdbc.DataSourceBuilder;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

import com.sitaluo.service.UserServiceDetail;

@Configuration
@EnableAuthorizationServer
public class OAuth2AuthrizationConfig extends AuthorizationServerConfigurerAdapter{
	
	@Autowired
	@Qualifier("dataSource")
	private DataSource dataSource;
	

	JdbcTokenStore tokenStore;
	@PostConstruct
	public void init() {
		tokenStore = new JdbcTokenStore(dataSource);
	}
	
	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserServiceDetail userServiceDetail;
	
	@Override
	public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
		clients.inMemory()
		.withClient("browser")
		.authorizedGrantTypes("refresh_token","password")
		.scopes("ui")
		.and()
		.withClient("service-hi")
		.secret("123456")
		.authorizedGrantTypes("client_credentials","refresh_token","password")
		.scopes("server");
	}
	
	@Override
	public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
		endpoints
			.tokenStore(tokenStore)
			.authenticationManager(authenticationManager)
			.userDetailsService(userServiceDetail);
	}
	
	@Override
	public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
		security.tokenKeyAccess("permitAll()")
		.checkTokenAccess("isAuthenticated()");
	}
	
	
}
