package com.certus.spring.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {
	
	
	//Definir Usuario en memoria [JPA -  Por alumnos J98 - calificado (P02)]
	
	@Bean
	InMemoryUserDetailsManager detailsManager() {
		
		User.UserBuilder usuarios = User.withDefaultPasswordEncoder();
		
		UserDetails UsuarioAdmin = usuarios
				.username("Admin")
				.password("1234")
				.roles("SuperAdmin")
				.build();
		
		UserDetails Usuario = usuarios
				.username("Invitado")
				.password("1234")
				.roles("User")
				.build();
		
		return new InMemoryUserDetailsManager(UsuarioAdmin, Usuario);
	} 
	
	
	@Bean
	SecurityFilterChain securityFilterChain( HttpSecurity http ) throws Exception {
		
		http.authorizeRequests(
				(req) -> req
						.antMatchers("/app/home", "/bootstrap/**", "/img/**").permitAll()
						.antMatchers("/app/listar").hasAnyRole("User","SuperAdmin")
						.antMatchers("/app/Editar/**").hasRole("SuperAdmin")
						.anyRequest().authenticated()
				
				).formLogin();
		
		return http.build();
		
	}
	
	

}
