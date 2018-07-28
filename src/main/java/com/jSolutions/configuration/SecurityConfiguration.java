package com.jSolutions.configuration;

import javax.servlet.http.HttpServletRequest;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationDetailsSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	/*@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/
	
	@Autowired
	private CustomAuthenticationProvider authProvider;


	/*@Autowired
	private DataSource dataSource;*/
	
	/*@Value("${spring.queries.users-query}")
	private String usersQuery;*/
	
	/*@Value("${spring.queries.roles-query}")
	private String rolesQuery;*/

	@Override
	protected void configure(AuthenticationManagerBuilder auth)
			throws Exception {
		auth.
			authenticationProvider(authProvider);
			/*.jdbcAuthentication()
				.usersByUsernameQuery(usersQuery)
				.authoritiesByUsernameQuery(rolesQuery)
				.dataSource(dataSource)
				.passwordEncoder(bCryptPasswordEncoder);*/
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("Configuring HttpSecurity");
		http.authorizeRequests().anyRequest().authenticated()
		.and()
		.csrf().disable().formLogin()
		.usernameParameter("email")
		.passwordParameter("password")
		.authenticationDetailsSource(authenticationDetailsSource())
		.and()
		.exceptionHandling().disable()
		.logout()
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/").and().exceptionHandling()
		.accessDeniedPage("/access-denied");
		/*http.
			authorizeRequests()
				.antMatchers("/login").permitAll()
				.antMatchers("/registration").permitAll()
				.anyRequest().authenticated().and().csrf().disable().formLogin()
				.loginPage("/login").failureUrl("/login?error=true")
				.failureForwardUrl("/login?error=true")
				.defaultSuccessUrl("/")
				.usernameParameter("email")
				.passwordParameter("password")
				.authenticationDetailsSource(authenticationDetailsSource())
				.and()
				.exceptionHandling().disable()
				.logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").and().exceptionHandling()
				.accessDeniedPage("/access-denied");*/
	}
	
	@Override
	public void configure(WebSecurity web) throws Exception {
	    web
	       .ignoring()
	       .antMatchers("/resources/**", "/assets/**", "/static/**", "/css/**", "/js/**", "/images/**");
	}
	
	private AuthenticationDetailsSource<HttpServletRequest, CustomWebAuthenticationDetails> authenticationDetailsSource() {

        return new AuthenticationDetailsSource<HttpServletRequest, CustomWebAuthenticationDetails>() {

            @Override
            public CustomWebAuthenticationDetails buildDetails(
                    HttpServletRequest request) {
                return new CustomWebAuthenticationDetails(request);
            }

        };
    }
}