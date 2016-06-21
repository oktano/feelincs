package com.reactiveiq.crowdfunding.web.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.domain.Company;
import com.reactiveiq.crowdfunding.domain.Development;
import com.reactiveiq.crowdfunding.domain.LookupData;
import com.reactiveiq.crowdfunding.domain.Transaction;
import com.reactiveiq.crowdfunding.service.TransactionService;

@ViewScoped
@Named
public class TransactionListBean implements Serializable{

	private final static Logger LOGGER=LoggerFactory.getLogger(TransactionListBean.class);
	
	@Inject
	private transient TransactionService transactionservice;
	
	private List<Transaction> transactionList=new ArrayList<>();
	
	private List<LookupData> filteredTransactionList=null;
	
	@PostConstruct
	private void init(){
		
		transactionList=new ArrayList<>();
		Transaction transaction=new Transaction();
		transaction.setCurrency("USD");
		transaction.setDateJoined(Calendar.getInstance().getTime());
	
		Development development=new Development();
		Company company=new Company();
		company.setCompanyName("Mesa");
		development.setDealType("Equity");
		development.setName("Mesa Cengelkoy");
		development.setPrice(5000000d);
		development.setPercentage(10);
		development.setTotalInvestor(5);
		
		transaction.setDevelopment(development);
		
		Account account=new Account();
		account.setFirstName("Ahmet");
		account.setLastName("Sayin");

		account.setUserName("ahmet@ahmetsayin.com");
		transaction.setInvestor(account);
		transaction.setInvesmentAmount(10000);
		transaction.setStatus(Boolean.TRUE);
		
		
		transactionList.add(transaction);

		
		transaction=new Transaction();
		transaction.setCurrency("USD");
		transaction.setDateJoined(Calendar.getInstance().getTime());
	
		development=new Development();
		company=new Company();
		company.setCompanyName("Mesa");
		development.setDealType("Equity");
		development.setName("Mesa Cengelkoy");
		development.setPrice(5000000d);
		development.setPercentage(10);
		development.setTotalInvestor(5);
		
		transaction.setDevelopment(development);
		
		account=new Account();
		account.setLastName("Veli");
		account.setFirstName("Ali");
		account.setUserName("alican@alican.com");
		transaction.setInvestor(account);
		transaction.setInvesmentAmount(10000);
		transaction.setStatus(Boolean.TRUE);
		
		transactionList.add(transaction);
		
	}

	public List<Transaction> getTransactionList() {
		return transactionList;
	}

	public void setTransactionList(List<Transaction> transactionList) {
		this.transactionList = transactionList;
	}

	public List<LookupData> getFilteredTransactionList() {
		return filteredTransactionList;
	}

	public void setFilteredTransactionList(List<LookupData> filteredTransactionList) {
		this.filteredTransactionList = filteredTransactionList;
	}
	
	public void approve(Transaction transaction){
		
		transaction.setStatus(Boolean.TRUE);
	}

	public void reject(Transaction transaction){
	
		transaction.setStatus(Boolean.FALSE);
		
	}

}
