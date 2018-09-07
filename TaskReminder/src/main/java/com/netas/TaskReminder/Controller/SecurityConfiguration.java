package com.netas.TaskReminder.Controller;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
@Configuration
public class SecurityConfiguration extends  WebSecurityConfigurerAdapter {
  @Autowired
  private DataSource dataSource;
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    
    http.authorizeRequests().antMatchers("/**/favicon.ico", "/css/**", "js/**", "/images/**", "/webjars/**","/login.html","/user/saveUser")
    .permitAll();
http.authorizeRequests().anyRequest().authenticated();
http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");

  }
}
