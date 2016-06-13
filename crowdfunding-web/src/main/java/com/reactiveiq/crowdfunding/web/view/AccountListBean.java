package com.reactiveiq.crowdfunding.web.view;


import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.service.AccountService;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;

/**
 * @brief Retrieve List of Users from accountservice for user management page
 * @author ksuicmez
 *
 */
@Named("accountListBean")
@ViewScoped
public class AccountListBean  implements Serializable{
	
	private final static Logger LOGGER=LoggerFactory.getLogger(AccountListBean.class);

	@Inject
	private transient AccountService accountService;
	
	private List<Account>accountList=null;
	
	private List<Account>filteredAccountList=null;
	
	@PostConstruct
	private void init(){
		//TODO Pagination
		//accountList=accountService.findAll();
		
	}
	
	public void activate(Account account){
		try {
			LOGGER.debug("Activating {}",account.getUserName());
			
			account.getAccountStatus().setAccountEnabled(true);
			
			accountService.save(account);
			
			LOGGER.debug("{} Activated",account.getUserName());
			

			init();
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("label.updated",FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		}
		catch(Exception ex){
			ex.printStackTrace();
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("error.general",FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		
	}
	
	public void deactivate(Account account){
		try {
			LOGGER.debug("DeActivating {}",account.getUserName());

			account.getAccountStatus().setAccountEnabled(false);
			accountService.save(account);
			LOGGER.debug("{} DeActivated",account.getUserName());

			init();
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("label.updated",FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		}
		catch(Exception ex){
			ex.printStackTrace();
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("error.general",FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
	}

	public List<Account> getAccountList() {
		return accountList;
	}

	public void setAccountList(List<Account> accountList) {
		this.accountList = accountList;
	}

	public List<Account> getFilteredAccountList() {
		return filteredAccountList;
	}

	public void setFilteredAccountList(List<Account> filteredAccountList) {
		this.filteredAccountList = filteredAccountList;
	}


}
