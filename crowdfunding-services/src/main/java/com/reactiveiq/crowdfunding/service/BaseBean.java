package com.reactiveiq.crowdfunding.service;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.domain.Property;


public abstract class BaseBean{
	
	@PersistenceContext(unitName = "crowdFunding") 
	private EntityManager entityManager;
	
	private Logger logger=LoggerFactory.getLogger(this.getClass());
	
	protected EntityManager getEntityManager(){
		return entityManager;
	}

	public Logger getLogger() {
		return logger;
	}

}
