package com.reactiveiq.crowdfunding.web.view.property;

import java.io.Serializable;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.domain.Property;
import com.reactiveiq.crowdfunding.service.PropertyService;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;

@ViewScoped
@Named("propertyEntryBean")
public class PropertyEntryBean implements Serializable {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	
	@Inject 
	private transient PropertyService propertyService;

	private Property property = new Property();
	
	public void save(){
		
		try {
			propertyService.save(property);
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("label.updated",FacesMessage.SEVERITY_INFO );
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);

		} catch (Exception e) {
			logger.error("Error occured while saving Property" ,e);
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("error.general", FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
		
		
	}

	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}
	
}
