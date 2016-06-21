package com.reactiveiq.crowdfunding.web.security;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import com.reactiveiq.crowdfunding.annotation.SpringBean;
import com.reactiveiq.crowdfunding.security.AuthenticationService;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;


/**
 * 
 * @author ksuicmez
 *
 */
@Named
@RequestScoped
public class LoginBean{
	
    private final static Logger LOGGER=LoggerFactory.getLogger(LoginBean.class);
    
    @Inject
    private MessageUtilBean messageUtilBean;
    
    @Inject 
    @SpringBean
	private AuthenticationService authenticationService; 
    
    private String userName;
   
    private String password;
    
    
    public String login() {
    		
    	
    	
    		boolean result=false;
        	try{
         		LOGGER.debug("Authentication for {}",userName);
         	   
        		FacesContext facesContext = FacesContext.getCurrentInstance();
                result= authenticationService.login(userName, password,facesContext.getExternalContext().getRequest());
        		
        		LOGGER.debug("Authentication succeed for {}",userName);

        	}
        	catch(AuthenticationException ex){
        		
        		result=false;
        		
        		LOGGER.error("Authentication failed for {}",userName,ex);
    	        
            	FacesMessage facesMsg = messageUtilBean.getFacesMessage(ex.getMessage());
                FacesContext.getCurrentInstance().addMessage(null, facesMsg);
        	}
            
        	//if authenticated redirect to  dashboard
        	if(result){
        		return "/dashboard.html??faces-redirect=true";
        	}
            return null;
    }
    
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    	
    /**@brief Invalidate HttpSession and logout
     * 
     * @throws Exception
     */
	public void logout()throws Exception {
		SecurityContextHolder.getContext().setAuthentication(null);
		HttpSession httpSession = (HttpSession)FacesContext.getCurrentInstance().getExternalContext().getSession(false);
		httpSession.invalidate();				 
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/login.html");
	}
	
	/**
	 * 
	 * @return true if user is authenticated
	 */
	public boolean isAuthenticated(){
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		if(authentication!=null && authentication.getName()!=null && !authentication.getName().equals("anonymousUser")){
			return true;
		}
		return false;
		
		
	}
    
}