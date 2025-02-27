package com.ciber.auth;

import java.util.Arrays;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{

	@Override
	public void configure(HttpSecurity http) throws Exception {
		 http.authorizeRequests().antMatchers("/api").permitAll()
         .antMatchers("/login").permitAll()
         .antMatchers("/token").permitAll()
         .antMatchers("/curso/**").permitAll()
         .antMatchers("/cuestionario/**").permitAll()
         .antMatchers("/pregunta/**").permitAll()
         .antMatchers("/pregunta-respuesta/**").permitAll()
         .antMatchers("/respuesta/**").permitAll()
         .antMatchers("/resultados-reportes/**").permitAll()
         .antMatchers("/seguimiento/**").permitAll()
         .antMatchers("/obtenerFoto/{codigo}").permitAll()
         .antMatchers("/archivos/{per_codigo}/{uaa}/{usuario}").permitAll()
         .antMatchers("/archivos/{usuario}/{uaa}").permitAll()
         .antMatchers("/assets/**").permitAll()
         .antMatchers("/**.png").permitAll()
         .antMatchers("/**.js").permitAll()
         .antMatchers("/**.css").permitAll()
         .anyRequest().authenticated()
         .and()
         .formLogin()
         .loginPage("/").permitAll()
         .and().cors().configurationSource(corsConfigurationSource());
	}
	
	@Bean
	public CorsConfigurationSource corsConfigurationSource() {
		CorsConfiguration config = new CorsConfiguration();
		config.setAllowedOrigins(Arrays.asList("*"));
		config.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
		config.setAllowCredentials(false);
		config.setAllowedHeaders(Arrays.asList("Content-Type", "Authorization"));
		
		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", config);
		return source;
	}
	
	@Bean
	public FilterRegistrationBean<CorsFilter> corsFilter(){
		FilterRegistrationBean<CorsFilter> bean = new FilterRegistrationBean<CorsFilter>(new CorsFilter(corsConfigurationSource()));
		bean.setOrder(Ordered.HIGHEST_PRECEDENCE);
		return bean;
	}


	
}