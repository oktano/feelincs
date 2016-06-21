package com.reactiveiq.crowdfunding.service;

import java.util.List;

import com.reactiveiq.crowdfunding.domain.LookupData;
import com.reactiveiq.crowdfunding.domain.LookupDataType;
import com.reactiveiq.crowdfunding.domain.Role;


public interface ReferenceDataService extends PersistenceService<LookupData>{
	
    public List<Role>getRoles();
    
    public List<LookupData>findAll();
    
    public List<LookupDataType>findAllLookupDataType();
        
 }
