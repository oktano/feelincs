package com.reactiveiq.crowdfunding.security.impl;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Service;

import com.reactiveiq.crowdfunding.security.AuthenticationService;

@Service("authenticationService")
public class AuthenticationServiceImpl implements AuthenticationService {

	
	@Autowired
	private AuthenticationManager authenticationManager; // specific for Spring Security
	

	public boolean login(String username, String password,Object request ) {
		try {
			Authentication authentication = new UsernamePasswordAuthenticationToken(username,password);	
	      	
			
			authentication = authenticationManager.authenticate(authentication);	
			SecurityContextHolder.getContext().setAuthentication(authentication);
			 WebAuthenticationDetails details=new WebAuthenticationDetails((HttpServletRequest)request);
			 ((UsernamePasswordAuthenticationToken) authentication).setDetails(details);
			
			
			if (authentication.isAuthenticated()) {
				return true;
			}
			
		} catch (AuthenticationException e) {			
			throw e;
		}
		
		return false;
	}
	
}
