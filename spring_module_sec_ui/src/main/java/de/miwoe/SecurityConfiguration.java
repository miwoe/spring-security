package de.miwoe;

import java.security.SecureRandom;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.csrf.CsrfFilter;
import org.springframework.security.web.csrf.CsrfTokenRepository;
import org.springframework.security.web.csrf.HttpSessionCsrfTokenRepository;

import de.miwoe.auth.CustomPasswordEncoder;
import de.miwoe.auth.DBUserDetailsService;

@Configuration
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
 
	@Autowired
	DBUserDetailsService userDetailsService;
	
	@Autowired
	CustomPasswordEncoder customPasswordEncoder;
	
	 @Autowired
	 public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		 auth.userDetailsService(userDetailsService).passwordEncoder(customPasswordEncoder);
	 }
	
  @Override
  protected void configure(HttpSecurity http) throws Exception {
	  http
      .httpBasic().and()
      .authorizeRequests()
        .antMatchers("/index.html", "/home.html", "/login.html", "/", "/console/*", "/registeruser").permitAll().anyRequest()
        .authenticated().and()
      .addFilterAfter(new CsrfHeaderFilter(), CsrfFilter.class)
	  .csrf().csrfTokenRepository(csrfTokenRepository());
      //.csrf().disable();
  }
  
  private CsrfTokenRepository csrfTokenRepository() {
	  HttpSessionCsrfTokenRepository repository = new HttpSessionCsrfTokenRepository();
	  repository.setHeaderName("X-XSRF-TOKEN");
	  return repository;
	}
  
}