package com.reactiveiq.crowdfunding.web.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.primefaces.event.RowEditEvent;

import com.reactiveiq.crowdfunding.domain.ApplicationSetting;
import com.reactiveiq.crowdfunding.service.ApplicationSettingService;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;

@Named("applicationSettingsBean")
@ViewScoped
public class ApplicationSettingsBean  implements Serializable{
	
	
	@Inject
	private transient ApplicationSettingService applicationSettingService;
		
	private List<ApplicationSetting>applicationSettingsList=new ArrayList<>();
	
	@PostConstruct
	private void init(){
		
		applicationSettingsList.addAll(applicationSettingService.findAll());

	}

	public List<ApplicationSetting> getApplicationSettingsList() {
		return applicationSettingsList;
	}

	public void setApplicationSettingsList(List<ApplicationSetting> applicationSettingsList) {
		this.applicationSettingsList = applicationSettingsList;
	}
	
    public void onRowEdit(RowEditEvent event) {
       
    	try {
			ApplicationSetting setting=(ApplicationSetting) event.getObject();
			applicationSettingService.save(setting);
			applicationSettingsList.clear();
			init();
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("label.updated",FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
	
    	} catch (Exception e) {
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("error.general",FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		}
  
    }
	
	
}
