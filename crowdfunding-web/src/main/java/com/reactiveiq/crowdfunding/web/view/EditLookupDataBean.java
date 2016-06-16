package com.reactiveiq.crowdfunding.web.view;

import java.io.IOException;
import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.domain.LookupData;
import com.reactiveiq.crowdfunding.domain.LookupDataType;
import com.reactiveiq.crowdfunding.service.ReferenceDataService;
import com.reactiveiq.crowdfunding.web.utils.ErrorHandler;
import com.reactiveiq.crowdfunding.web.utils.MessageUtilBean;

@ViewScoped
@Named
public class EditLookupDataBean implements Serializable{

	private final static Logger LOGGER=LoggerFactory.getLogger(EditLookupDataBean.class);
	
	@Inject
	private transient ReferenceDataService referenceDataService;
	
	
	private LookupDataType selectedLookupDataType;
	
	private LookupData selectedLookupData;
	
	
	@PostConstruct
	private void init(){
		

		String type=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("type");		
	
		if(StringUtils.isEmpty(type)){
			
			ErrorHandler.catch404Error();
			return;
		}
		
		List<LookupDataType> tmpLookupDataTypeList=referenceDataService.findAllLookupDataType().stream().
												filter(e->e.getName().equals(type)).collect(Collectors.toList());
		
		if(tmpLookupDataTypeList.isEmpty()){
			ErrorHandler.catch404Error();
			return;
			
		}
		selectedLookupDataType=tmpLookupDataTypeList.get(0);
		
		String id=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("id");
		
		if(StringUtils.isEmpty(id)){
			selectedLookupData=new LookupData();
			selectedLookupData.setLookupDataType(selectedLookupDataType);
		}
		else {
			selectedLookupData=referenceDataService.findById(Long.valueOf(id));
		}
	}


	public void save(){
		try{
			
			referenceDataService.save(selectedLookupData);
			
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("label.updated",FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/lookupdata.html?type="+selectedLookupDataType.getName());			
			
		}
		catch(Exception ex){
			LOGGER.error("Error occured while adding lookup entity",ex);
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("error.general",FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		
		}
	}

	public void cancel()throws IOException{
		ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
		ec.redirect(ec.getRequestContextPath() + "/lookupdata.html?type="+selectedLookupDataType.getName());
	}

	
	public LookupDataType getSelectedLookupDataType() {
		return selectedLookupDataType;
	}


	public void setSelectedLookupDataType(LookupDataType selectedLookupDataType) {
		this.selectedLookupDataType = selectedLookupDataType;
	}


	public LookupData getSelectedLookupData() {
		return selectedLookupData;
	}


	public void setSelectedLookupData(LookupData selectedLookupData) {
		this.selectedLookupData = selectedLookupData;
	}
	

	
}
