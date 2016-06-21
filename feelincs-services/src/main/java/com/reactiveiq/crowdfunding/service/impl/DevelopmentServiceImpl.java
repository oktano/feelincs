package com.reactiveiq.crowdfunding.service.impl;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import com.reactiveiq.crowdfunding.domain.Development;
import com.reactiveiq.crowdfunding.service.BaseService;
import com.reactiveiq.crowdfunding.service.DevelopmentService;

@Singleton
@Transactional
public class DevelopmentServiceImpl  extends BaseService implements DevelopmentService{

	@Override
	public void save(Development entity) {
		if(entity.getId()==null){
			getEntityManager().persist(entity);
		}
		else {
			getEntityManager().merge(entity);
			
		}
		
	}

	@Override
	public Development findById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
