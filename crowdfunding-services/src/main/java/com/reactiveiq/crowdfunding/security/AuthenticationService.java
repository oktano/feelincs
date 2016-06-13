package com.reactiveiq.crowdfunding.security;


public interface AuthenticationService {
	
	public boolean login(String username, String password,Object clientRequest);

}
