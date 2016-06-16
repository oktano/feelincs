package com.reactiveiq.crowdfunding.web.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.view.ViewScoped;
import javax.faces.context.FacesContext;
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
public class ManageLookupDataListBean implements Serializable{

	private final static Logger LOGGER=LoggerFactory.getLogger(ManageLookupDataListBean.class);
	
	@Inject
	private transient ReferenceDataService referenceDataService;
	
	private List<LookupData> lookupDataList=new ArrayList<>();
	
	private List<LookupData> filteredLookupDataList=null;

	private List<LookupDataType>lookupDataTypeList=new ArrayList<>();
	
	private LookupDataType selectedLookupDataType;
	
	private String type="";
	
	@PostConstruct
	private void init(){
		
		lookupDataTypeList=	referenceDataService.findAllLookupDataType();
		
		type=FacesContext.getCurrentInstance().getExternalContext().getRequestParameterMap().get("type");		
	
		if(StringUtils.isEmpty(type)){
			
			ErrorHandler.catch404Error();
			return;
		}
		
		List<LookupDataType> tmpLookupDataTypeList=lookupDataTypeList.stream().
										filter(e->e.getName().equals(type)).collect(Collectors.toList());
		
		if(tmpLookupDataTypeList.isEmpty()){
			ErrorHandler.catch404Error();
			return;
			
		}
		selectedLookupDataType=tmpLookupDataTypeList.get(0);
		
		lookupDataList.addAll(selectedLookupDataType.getLookupDataList());
	}


	public void changeStatus(LookupData entity){
		try{
			
			entity.setDeleted(!entity.isDeleted());
			
			referenceDataService.save(entity);
			
			lookupDataList.clear();

			lookupDataList.addAll(findLookupData(type));
			
			
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("label.updated",FacesMessage.SEVERITY_INFO);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
			
		}
		catch(Exception ex){
			LOGGER.error("Error occured while removing lookup entity");
			FacesMessage facesMessage=MessageUtilBean.getFacesMessage("error.general",FacesMessage.SEVERITY_ERROR);
			FacesContext.getCurrentInstance().addMessage(null, facesMessage);
		
		}
	}
	
	public List<LookupData> getLookupDataList() {
		return lookupDataList;
	}


	public void setLookupDataList(List<LookupData> lookupDataList) {
		this.lookupDataList = lookupDataList;
	}


	public List<LookupDataType> getLookupDataTypeList() {
		return lookupDataTypeList;
	}


	public void setLookupDataTypeList(List<LookupDataType> lookupDataTypeList) {
		this.lookupDataTypeList = lookupDataTypeList;
	}


	public LookupDataType getSelectedLookupDataType() {
		return selectedLookupDataType;
	}


	public void setSelectedLookupDataType(LookupDataType selectedLookupDataType) {
		this.selectedLookupDataType = selectedLookupDataType;
	}


	public List<LookupData> getFilteredLookupDataList() {
		return filteredLookupDataList;
	}


	public void setFilteredLookupDataList(List<LookupData> filteredLookupDataList) {
		this.filteredLookupDataList = filteredLookupDataList;
	}
	
	
	private List<LookupData>findLookupData(String type){
		
		return  referenceDataService.findAllLookupDataType().
							stream().filter(e->e.getName().equals(type)).collect(Collectors.toList()).get(0).getLookupDataList();
	}
	
	
	
}
