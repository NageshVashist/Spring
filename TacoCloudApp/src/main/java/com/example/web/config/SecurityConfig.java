package com.example.web.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
//	@Autowired
//	DataSource dataSource;
	@Autowired
	private UserDetailsService userDetailsService;
	@Autowired
	PasswordEncoder encoder;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {

		// An in-memory user store
//		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("password")).roles("USER").and()
//				.withUser("admin").password(encoder.encode("password")).roles("USER", "ADMIN");

		// A JDBC-based user store
//		auth.jdbcAuthentication().dataSource(dataSource)
//				.usersByUsernameQuery("select username, password, enabled from Users " + "where username=?")
//				.authoritiesByUsernameQuery("select username, authority from UserAuthorities " + "where username=?")
//				.passwordEncoder(encoder);

		// An LDAP-backed user store

//		auth.ldapAuthentication().userSearchBase("ou=people").userSearchFilter("(uid={0})").groupSearchBase("ou=groups")
//				.groupSearchFilter("member={0}").passwordCompare().passwordEncoder(new BCryptPasswordEncoder())
//				.passwordAttribute("passcode").contextSource().root("dc=tacocloud,dc=com");

		// A custom user details service

		auth.userDetailsService(userDetailsService).passwordEncoder(encoder);
	}

	// Expose the UserDetailsService as a Bean
	@Bean
	@Override
	public UserDetailsService userDetailsServiceBean() throws Exception {
		return super.userDetailsServiceBean();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/design", "/orders/**").hasRole("USER").antMatchers("/**")
				.access("permitAll").and().formLogin().loginPage("/login").defaultSuccessUrl("/design").and().logout()
				.logoutSuccessUrl("/").and().authorizeRequests().antMatchers("/h2-console/**").hasRole("USER")
				.anyRequest().authenticated().and().formLogin().and().csrf().ignoringAntMatchers("/h2-console/**").and()
				.headers().frameOptions().sameOrigin();
	}

	@Bean
	public PasswordEncoder encoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}

}