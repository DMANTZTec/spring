package com.fmc.dzone.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.fmc.dzone.handler.AppDataAuthenticationSuccessHandler;


@Configuration
@EnableWebSecurity
public class AppDataSecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
	DataSource dataSource;

	@Autowired
	private AppDataAuthenticationSuccessHandler successHandler;

	// Enable jdbc authentication
	@Autowired
	public void configAuthentication(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/resources/**");
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/").permitAll().antMatchers("/welcome").hasAnyRole("USER", "ADMIN")
				.antMatchers("/getApps").hasAnyRole("USER", "ADMIN").antMatchers("/welcome")
				.hasAnyRole("ADMIN").anyRequest().authenticated().and().formLogin().successHandler(successHandler)
				.loginPage("/login").permitAll().and().logout().permitAll();

		http.csrf().disable();
	}
	 @Autowired
		public void configureGlobal(AuthenticationManagerBuilder authenticationMgr)
		 throws Exception {
		 authenticationMgr.inMemoryAuthentication().withUser("admin").password("{noop}admin").authorities("ROLE_USER").and()
		 .withUser("sajana").password("{noop}sanju").authorities("ROLE_USER",
		 "ROLE_ADMIN");
		 }

}
