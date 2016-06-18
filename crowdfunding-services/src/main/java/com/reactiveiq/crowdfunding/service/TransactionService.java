package com.reactiveiq.crowdfunding.service;

import java.util.List;

import com.reactiveiq.crowdfunding.domain.Transaction;

public interface TransactionService extends PersistenceService<Transaction> {

	public List<Transaction>findAll();
	
}
