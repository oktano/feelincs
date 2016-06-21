package com.reactiveiq.crowdfunding.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import com.reactiveiq.crowdfunding.domain.ApplicationSetting;
import com.reactiveiq.crowdfunding.service.ApplicationSettingService;
import com.reactiveiq.crowdfunding.service.BaseService;
import com.reactiveiq.crowdfunding.service.ServiceConstants;

@Singleton
@Transactional
public class ApplicationSettingServiceBean extends BaseService implements ApplicationSettingService {

	
	@Override
	public List<ApplicationSetting> findAll() {
		return getEntityManager().createQuery("Select property from "
				+ "ApplicationSetting property " ,ApplicationSetting.class)
					.setMaxResults(ServiceConstants.MAX_QUERY_RESULT).getResultList();		
	}
	
	
	
	@Override
	public void save(ApplicationSetting entity) {
		if(entity.getId()==null){
			getEntityManager().persist(entity);
		}
		else {
			getEntityManager().merge(entity);
			
		}
		
	}

	@Override
	public ApplicationSetting findById(Long id) {
		return getEntityManager().find(ApplicationSetting.class, id);
	}



	@Override
	public Map<String, String> findAllToMap() {
		
		Map<String,String>appSettingsMap=new HashMap<>();
		
		for(ApplicationSetting appSetting:this.findAll()){
			appSettingsMap.put(appSetting.getKey(), appSetting.getValue());
		}
		return appSettingsMap;
	}
	
	

}
