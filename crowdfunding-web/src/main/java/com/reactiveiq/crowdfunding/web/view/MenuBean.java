package com.reactiveiq.crowdfunding.web.view;

import java.io.Serializable;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.reactiveiq.crowdfunding.domain.LookupDataType;
import com.reactiveiq.crowdfunding.service.ReferenceDataService;

@SessionScoped
@Named
public class MenuBean implements Serializable{

	@Inject
	private transient ReferenceDataService referenceDataService;
	
	private  List<LookupDataType>lookupDataTypeList;

	public List<LookupDataType> getLookupDataTypeList() {
		if(lookupDataTypeList==null){
			lookupDataTypeList=referenceDataService.findAllLookupDataType();
		}
		return lookupDataTypeList;
	}

	
}
