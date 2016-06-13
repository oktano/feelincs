package com.reactiveiq.crowdfunding.service;

import java.io.Serializable;

public interface PersistenceService<T> extends Serializable{
	
	public void save(T t);
		
	public T findById(Long id);

}
