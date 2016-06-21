package com.reactiveiq.crowdfunding.service;

import java.util.List;
import java.util.Map;

import com.reactiveiq.crowdfunding.domain.ApplicationSetting;

public interface ApplicationSettingService  extends PersistenceService<ApplicationSetting> {

	public Map<String,String>findAllToMap();
	
	public List<ApplicationSetting> findAll();	
}
