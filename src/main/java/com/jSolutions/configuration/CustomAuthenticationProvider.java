package com.jSolutions.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.stereotype.Component;

import com.jSolutions.entities.common.Domain;
import com.jSolutions.entities.common.User;
import com.jSolutions.services.common.DomainService;
import com.jSolutions.services.common.UserService;

@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {
	
	@Autowired
	private DomainService domainService;
	
	@Autowired
	private UserService userService;

	@Override
	public Authentication authenticate(Authentication authenitication) throws AuthenticationException {
		UsernamePasswordAuthenticationToken auth=(UsernamePasswordAuthenticationToken)authenitication;
		
		CustomWebAuthenticationDetails details=(CustomWebAuthenticationDetails)auth.getDetails();
		System.out.println("details>>>>>>>>>>>>>"+details);
		Domain domain= domainService.getByName(details.getDomainName());
		if(domain==null) {
			authenitication.setAuthenticated(false);
			return null;
		}
		User loginUser = new User();
		loginUser.setDomainId(domain.getId());
		String email=auth.getPrincipal().toString();
		User user = userService.getByEmail(email, loginUser);
		System.out.println("user>>>>>>>>>>>>>success>>>>"+user);
		if(user==null) {
			System.out.println("user is null returning>>>>>>>>>>>>>success>>>>"+user);
			authenitication.setAuthenticated(false);
			return null;
		}
		UsernamePasswordAuthenticationToken authToken=new UsernamePasswordAuthenticationToken(auth.getPrincipal(), 
				auth.getCredentials(), AuthorityUtils.createAuthorityList("ADMIN"));
		details.setUser(user);
		authToken.setDetails(details);
		System.out.println("details>>>>>>>>>>>>>success>>>>"+details);
		return authToken;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		System.out.println("CustomAuthenticationProvider>>>supports>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>"+clazz);
		return true;
	}

}
