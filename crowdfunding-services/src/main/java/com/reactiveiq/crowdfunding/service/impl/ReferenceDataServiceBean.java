package com.reactiveiq.crowdfunding.service.impl;
import java.util.List;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import com.reactiveiq.crowdfunding.domain.LookupData;
import com.reactiveiq.crowdfunding.domain.LookupDataType;
import com.reactiveiq.crowdfunding.domain.Role;
import com.reactiveiq.crowdfunding.service.BaseService;
import com.reactiveiq.crowdfunding.service.ReferenceDataService;

@Singleton
@Transactional
public class ReferenceDataServiceBean extends BaseService implements ReferenceDataService {
		

	public List<Role> getRoles() {
		
		return getEntityManager().createQuery(" Select  role "
													+ "	from Role role",Role.class)
													.getResultList();
	}

	@Override
	public void save(LookupData entity) {
		if(entity.getId()==null){
			getEntityManager().persist(entity);
		}
		else {
			getEntityManager().merge(entity);
		}
		
	}

	@Override
	public LookupData findById(Long id) {
		return getEntityManager().find(LookupData.class, id);
	}

	@Override
	public List<LookupData> findAll() {
		return getEntityManager().createQuery("Select  entity from"
				+ " LookupDataType entity",LookupData.class)
				.getResultList();
	}

	@Override
	public List<LookupDataType> findAllLookupDataType() {
	
		return getEntityManager().createQuery("Select  entity from"
				+ " LookupDataType entity",LookupDataType.class)
				.getResultList();
	}
	
	
	
}
