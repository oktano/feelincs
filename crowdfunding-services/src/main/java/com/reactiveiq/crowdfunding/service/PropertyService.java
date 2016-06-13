package com.reactiveiq.crowdfunding.service;

import java.util.List;

import com.reactiveiq.crowdfunding.domain.Property;

public interface PropertyService extends PersistenceService<Property> {

	public List<Property> findByPrice(double price, boolean isGreater);
	
}
