package com.todotask.api.config.security;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.todotask.api.config.util.JwtRequestFilter;
import com.todotask.api.service.MyUserDetailsService;




@SuppressWarnings("deprecation")

@EnableWebSecurity
public class SecurityConfigurer extends WebSecurityConfigurerAdapter{
	@Autowired
	private MyUserDetailsService myUserDetailsService;
	@Autowired
	private JwtRequestFilter jwtRequestFilter;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myUserDetailsService);
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}

	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}

	@Override
	protected void configure(HttpSecurity httpSecurity) throws Exception {
		
		
		
		httpSecurity.csrf().disable()
				.authorizeRequests().antMatchers("/home").permitAll().
				antMatchers("/requesttoken").permitAll().
						anyRequest().authenticated().and().
						exceptionHandling().and().sessionManagement()
				.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		
		
		httpSecurity.addFilterBefore(jwtRequestFilter, UsernamePasswordAuthenticationFilter.class);
		
		httpSecurity.cors().configurationSource(corsConfigurationSource());
		
		httpSecurity.requiresChannel()
	      .requestMatchers(r -> r.getHeader("X-Forwarded-Proto") != null)
	      .requiresSecure();

	}
	CorsConfigurationSource corsConfigurationSource() {
	    CorsConfiguration configuration = new CorsConfiguration();
	    List<String> allowOrigins = Arrays.asList("*");
	    configuration.setAllowedOrigins(allowOrigins);
	    configuration.setAllowedMethods(Collections.singletonList("*"));
	    configuration.setAllowedHeaders(Collections.singletonList("*"));
	    //in case authentication is enabled this flag MUST be set, otherwise CORS requests will fail
	    configuration.setAllowCredentials(false);
	    UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    source.registerCorsConfiguration("/**", configuration);
	    return source;
	}

	
}