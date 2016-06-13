package com.reactiveiq.crowdfunding.web.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.service.AccountService;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;


/**
 * AccountBean to retrieve Authenticated User
 * @author ksuicmez
 *
 */
@Named("accountBean")
@SessionScoped
public class AccountBean  implements Serializable{
	
    private final static Logger LOGGER=LoggerFactory.getLogger(AccountBean.class);

    
	@Inject
	private transient AccountService accountService;
		
	private Account account;
	
	
	@PostConstruct
	private void init(){
		
		Authentication authentication=SecurityContextHolder.getContext().getAuthentication();
		try{
			
			account=accountService.getAccountByUserName(authentication.getName());
		}
		catch(Exception th){
			
			LOGGER.error("Error occured while retrieving account info from db",th );
			FacesMessage msg = MessageUtilBean.getFacesMessage("msg.general.error", FacesMessage.SEVERITY_ERROR);  
			FacesContext.getCurrentInstance().addMessage(null, msg);  
	
		}
	}

	public Account getAccount() {
		return account;
	}

}
