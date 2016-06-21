package com.reactiveiq.crowdfunding.service.impl;

import java.util.List;

import javax.inject.Singleton;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.HttpHeaders;

import com.reactiveiq.crowdfunding.domain.Transaction;
import com.reactiveiq.crowdfunding.service.BaseService;
import com.reactiveiq.crowdfunding.service.TransactionService;

@Singleton
public class TransactionServiceImpl extends BaseService implements TransactionService {

	@Override
	public void save(Transaction entity) {
		getEntityManager().persist(entity);
		
	}

	@Override
	public Transaction findById(Long id) {
		return getEntityManager().find(Transaction.class,id);
	}

	@Override
	public List<Transaction> findAll() {
		return getEntityManager().createQuery("Select entity from "
				+ " Transaction entity ",Transaction.class)
				.getResultList();
				
	}

	
	
	
	
	
	
	
	
	
	
/*
	public static void main(String []args){
		  Client client = ClientBuilder.newClient();
		    WebTarget target = client.target(baseurl + "/v1/devices/events/")
		            .request("...")     
		            .header(HttpHeaders.AUTHORIZATION, "Bearer " + "... encoded token ...");
	}*/
}
