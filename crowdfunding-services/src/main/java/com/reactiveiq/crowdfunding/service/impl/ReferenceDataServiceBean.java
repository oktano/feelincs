package com.reactiveiq.crowdfunding.service.impl;
import java.util.List;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import com.reactiveiq.crowdfunding.domain.Role;
import com.reactiveiq.crowdfunding.service.BaseBean;
import com.reactiveiq.crowdfunding.service.ReferenceDataService;

@Singleton
@Transactional
public class ReferenceDataServiceBean extends BaseBean implements ReferenceDataService {
		

	public List<Role> getRoles() {
		
		return getEntityManager().createQuery(" Select  role from Role role",Role.class)
													.getResultList();
	}
	
}
