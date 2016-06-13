package com.reactiveiq.crowdfunding.web.listener;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;
import javax.enterprise.inject.Produces;
import javax.servlet.ServletContext;

import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.reactiveiq.crowdfunding.annotation.Initialized;
import com.reactiveiq.crowdfunding.annotation.SpringBean;
import com.reactiveiq.crowdfunding.security.AuthenticationService;

@ApplicationScoped
public class ApplicationInitializer
{
	
	private ServletContext _ctx;
	 
	public void onStartup(@Observes @Initialized ServletContext ctx)
	{
		_ctx=ctx;
	}
	
    
    @Produces
    @SpringBean
    private AuthenticationService getAuthenticationService(){
  
    	return WebApplicationContextUtils.getWebApplicationContext(_ctx).getBean(AuthenticationService.class);
    }
    
    @Produces
    @SpringBean
    private UserDetailsService getUserDetailsService(){
  
    	return WebApplicationContextUtils.getWebApplicationContext(_ctx).getBean(UserDetailsService.class);
    }
}