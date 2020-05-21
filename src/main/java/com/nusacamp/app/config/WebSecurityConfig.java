package com.nusacamp.app.config;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.nusacamp.app.service.UserService;



@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
		.antMatchers("/registration**",
				"/js/**",
				"/css/**",
				"/img/**",
				"/webjars/**").permitAll()
		.antMatchers("/bootstrap/**", "/dist/**", "/plugins/**").permitAll()
        .antMatchers("*").hasRole("ADMIN")
        .antMatchers("/users/**","/usertype/**").hasAuthority("ADMIN")
        .antMatchers("/#").hasAnyAuthority("ADMIN","KEMENKES","LAB","BNPB")
        .antMatchers("/items/**").hasAnyAuthority("ADMIN","KEMENKES")
        .antMatchers("/distribution/inbox/").hasAnyAuthority("ADMIN","LAB")
        .antMatchers("/distribution/add").hasAnyAuthority("ADMIN","KEMENKES")
        .antMatchers("/labs/add").hasAnyAuthority("ADMIN","LAB")
        .antMatchers("/brand/**","/category/**","/distributor/**","/stocksource/**").hasAnyAuthority("ADMIN","KEMENKES")
		.anyRequest().authenticated()
        .and()
    .formLogin()
        .failureUrl("/login?error")
        .loginPage("/login")
        .defaultSuccessUrl("/")
        .permitAll()
        .and()
    .logout()
        .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        .logoutSuccessUrl("/login")
        .permitAll()
        .and()
        .exceptionHandling().accessDeniedPage("/403");
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.authenticationProvider(authenticationProvider());
	}
	
	@Bean
	public DaoAuthenticationProvider authenticationProvider() {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userDetailsService);
		return provider;
	}
	
	

}
