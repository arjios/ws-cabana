package com.ios.cabana.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig {
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	@Order(Ordered.HIGHEST_PRECEDENCE)
	public SecurityFilterChain defaultFilterChain(HttpSecurity http) throws Exception {

// o codigo abaixo não precisa ser escrito no caso de usar o 
// OAuth2AuthorizationServerConfiguration
//
		return http
				.csrf(csrf -> csrf.disable())
				.authorizeHttpRequests(auth -> {
					auth.antMatchers("/").permitAll();
					auth.antMatchers("/users/admin/**").hasRole("ROLE_ADMIN");
					auth.antMatchers("/roles/admin/**").hasRole("ROLE_ADMIN");
					auth.antMatchers("/products/admin/**").hasRole("ROLE_ADMIN");
					auth.antMatchers("/categories/admin/**").hasRole("ROLE_ADMIN");
				})
				.httpBasic(Customizer.withDefaults())
				.build();
	}
	
}
