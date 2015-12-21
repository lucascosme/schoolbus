package br.com.lucassolutions.schoolbus.auth;


import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
@ImportResource({"classpath:spring/application-config.xml"})
public class MultiHttpSecurityConfig {

	private static final String DATA_SOURCE = "myDataSource";
	private static final String SELECT_USERS_BY_USERNAME_QUERY = "select userName, password, (select IF(userStatus != 'ACTIVE', '0', '1')) as enabled from users where userName=?";
	private static final String SELECT_AUTHORITIES_BY_USERNAME_QUERY = "select u.userName, ur.userRoleType from users u, userroles ur where u.id = ur.userid and u.userName=?";
	
	@Autowired private ApplicationContext context;
	
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
    	DataSource dataSource = (DataSource) context.getBean(DATA_SOURCE);
		auth.jdbcAuthentication().dataSource(dataSource)
			.passwordEncoder(passwordEncoder())
			.usersByUsernameQuery(SELECT_USERS_BY_USERNAME_QUERY)
			.authoritiesByUsernameQuery(SELECT_AUTHORITIES_BY_USERNAME_QUERY);
    }

	@Bean
	public PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
    
	@Configuration
	@Order(1)
	public static class ApiWebSecurityConfigurationAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			http
				.antMatcher("/api/**")
				.authorizeRequests()
					.anyRequest().access("hasRole('API')")
				.and()
					.httpBasic()
				.and()
					.csrf().disable();
		}
	}

	@Configuration
	public static class FormLoginWebSecurityConfigurerAdapter extends WebSecurityConfigurerAdapter {

		@Override
		protected void configure(HttpSecurity http) throws Exception {
			
	    	http.authorizeRequests()
				.antMatchers("/controller/user/**").access("hasRole('USER')")
				.antMatchers("/controller/admin/**").access("hasRole('ADMIN')")
				.and()
					.formLogin().loginPage("/login").failureUrl("/login?error")
						.usernameParameter("username").passwordParameter("password")
				.and()
					.logout().logoutSuccessUrl("/login?logout")
				.and()
					.exceptionHandling().accessDeniedPage("/403")
				.and()
					.csrf();
		}
	}
	
}