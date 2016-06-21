package com.reactiveiq.crowdfunding.web.view;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.validation.ValidationException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.service.AccountService;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;


@Named("signupBean")
@RequestScoped
public class SignupBean{
	

	private final static Logger LOGGER=LoggerFactory.getLogger(SignupBean.class);
	
    private Account account=new Account();
    
	private ShaPasswordEncoder encoder=new ShaPasswordEncoder(256);

    @Inject
    private MessageUtilBean messageUtilBean;
    
    private String password;
    
    @Inject
    private transient AccountService accountService;
    
    
    public void signup(){
    	
    	try {
			account.setPassword(encoder.encodePassword(password,account.getUserName()));	
			accountService.save(account);
			FacesMessage facesMessage=messageUtilBean.getFacesMessage(messageUtilBean.getMessage("label.login.accessrequestsent"));
			facesMessage.setSeverity(FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}		
    	catch(ValidationException ex){
			LOGGER.error("Validation exception",ex);
			
			FacesMessage facesMessage=messageUtilBean.getFacesMessage(ex.getMessage(), FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			return;
   
    	}
		catch(Exception ex){
			LOGGER.error("Exception occured while registering",ex);

			FacesMessage facesMessage=messageUtilBean.getFacesMessage("msg.general.error", FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			
		}
		return ;

    }

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}


	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
    
}