package com.netas.TaskReminder.Controller;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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
    
    http.authorizeRequests().antMatchers("/**/favicon.ico", "/css/**", "js/**", "/images/**", "/webjars/**","/login.html").permitAll()
    .antMatchers("/user/findall").access("hasRole('ROLE_EDITOR')")
    .antMatchers("/user/**").access("hasRole('ROLE_ADMIN')")
    .anyRequest().authenticated();
    http.formLogin().loginPage("/login.html").loginProcessingUrl("/login")
    .failureUrl("/login.html?loginFailed=true");
http.httpBasic();
/*http.authorizeRequests().anyRequest().authenticated()
.antMatchers("/user/**").hasRole("ADMİN")
.anyRequest().authenticated().and().formLogin().loginPage("/login.html").permitAll().and().logout()
.permitAll();
//http.formLogin().loginPage("/login.html").loginProcessingUrl("/login").failureUrl("/login.html?loginFailed=true");
*/
  }
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception { 
      auth.jdbcAuthentication().dataSource(dataSource);
     // .usersByUsernameQuery("select username,password, enabled from users where username=?")
     // .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
  }
}
