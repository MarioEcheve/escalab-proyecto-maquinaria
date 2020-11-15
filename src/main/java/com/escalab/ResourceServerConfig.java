package com.escalab;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	/*
	@Autowired
	private ResourceServerTokenServices tokenServices;
	*/
	
	@Value("${security.jwt.resource-ids}")
	private String resourceIds;
	
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http
		.exceptionHandling().authenticationEntryPoint(new AuthException())
		.and()
		.requestMatchers()
		.and()
		.authorizeRequests()
		.antMatchers("/v2/api-docs/**").authenticated()
		.antMatchers("/consultas/**").authenticated()
		.antMatchers("/especialidades/**").authenticated()
		.antMatchers("/examenes/**").authenticated()
		.antMatchers("/medicos/**").authenticated()
		.antMatchers("/menus/**").authenticated()
		.antMatchers("/tokens/**").permitAll()
		.antMatchers("/consultaexamenes/**").authenticated()
		.antMatchers("/pacientes/**").authenticated();
	}
	
}
