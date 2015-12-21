package br.com.lucassolutions.schoolbus.auth;

import org.springframework.security.web.context.AbstractSecurityWebApplicationInitializer;


public class SecurityWebApplicationInitializer extends AbstractSecurityWebApplicationInitializer {

	public SecurityWebApplicationInitializer() {
		super(MultiHttpSecurityConfig.class);
	}
}
