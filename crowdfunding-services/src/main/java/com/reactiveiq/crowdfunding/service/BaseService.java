package com.reactiveiq.crowdfunding.service;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public abstract class BaseService{
	
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
