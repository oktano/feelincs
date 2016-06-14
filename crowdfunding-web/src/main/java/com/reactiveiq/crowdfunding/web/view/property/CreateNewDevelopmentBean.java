

package com.reactiveiq.crowdfunding.web.view.property;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.domain.Company;
import com.reactiveiq.crowdfunding.domain.Development;
import com.reactiveiq.crowdfunding.service.DevelopmentService;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;

@Named
@ViewScoped
public class CreateNewDevelopmentBean implements Serializable {
	
	private static  final Logger LOGGER = LoggerFactory.getLogger(CreateNewDevelopmentBean.class);
	
	@Inject
	private transient DevelopmentService developmentService ;
		
	private Development development = new Development() ;

	@PostConstruct
	private void init(){
	
		development.setCompany(new Company());
		
	}
	
	
	public void save(Development development){
		
		try {
			
				developmentService.save(development);
				FacesMessage facesMessage=MessageUtilBean.getFacesMessage("development.created",FacesMessage.SEVERITY_INFO );
				FacesContext.getCurrentInstance().addMessage(null, facesMessage);

			
						
			
		} catch (Exception e) {
			
			LOGGER.error("Error while creating development",e);
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("error.general", FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			
		}
			
	}

	
	public Development getDevelopment() {
		return development;
	}

	public void setDevelopment(Development development) {
		this.development = development;
	}
}
