package com.jSolutions.configuration;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.web.authentication.WebAuthenticationDetails;

import com.jSolutions.entities.common.User;

public class CustomWebAuthenticationDetails extends WebAuthenticationDetails{
	private static final long serialVersionUID = 7L;
	private final String domainName;
	private User user;
	public CustomWebAuthenticationDetails(HttpServletRequest request) {
		super(request);
		this.domainName=request.getServerName().split("\\.")[0];
	}

	public String getDomainName() {
		return this.domainName;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		StringBuilder sb=new StringBuilder();
		sb.append("{");

		sb.append("domainName:");
		sb.append(domainName);
		sb.append(",");
		sb.append("user:");
		sb.append(user);

		sb.append("}");
		return sb.toString();
	}

}
