package com.reactiveiq.crowdfunding.service.impl;

import java.util.List;

import javax.inject.Singleton;
import javax.transaction.Transactional;

import com.reactiveiq.crowdfunding.domain.Property;
import com.reactiveiq.crowdfunding.service.BaseBean;
import com.reactiveiq.crowdfunding.service.PropertyService;

@Singleton
@Transactional
public class PropertyServiceImpl extends BaseBean implements PropertyService {

	@Override
	public void save(Property entity) {
		if(entity.getId()==null){
			getEntityManager().persist(entity);
		}
		else {
			getEntityManager().merge(entity);			
		}

	}

	@Override
	public Property findById(Long id) {
		return getEntityManager().find(Property.class, id);		
	}
	

	@Override
	public List<Property> findByPrice(double price,boolean isGreater) {
	
		if(isGreater){
			return getEntityManager().createQuery("Select entity from Property entity "
					+ "				where entity.price>=:price",Property.class)
					.setParameter("price", price)
					.getResultList();
		}
		else {
			return getEntityManager().createQuery("Select entity from Property entity "
					+ "				where entity.price<=:price",Property.class)
					.setParameter("price", price)
					.getResultList();
			
		}
	}

}
