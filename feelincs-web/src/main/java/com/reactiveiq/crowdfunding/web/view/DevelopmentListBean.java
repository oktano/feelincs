package com.reactiveiq.crowdfunding.web.view;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.reactiveiq.crowdfunding.domain.Account;
import com.reactiveiq.crowdfunding.domain.Company;
import com.reactiveiq.crowdfunding.domain.Development;

@ViewScoped
@Named
public class DevelopmentListBean implements Serializable{

	private final static Logger LOGGER=LoggerFactory.getLogger(TransactionListBean.class);
	
	
	private List<Development> developmentList=new ArrayList<>();
	
	private List<Development> filteredDevelopmentList=null;
	
	@PostConstruct
	private void init(){
		
		developmentList=new ArrayList<>();
		Development development=new Development();
		
		Account account=new Account();
		account.setFirstName("Mesa");
		account.setLastName("Admin");
		development.setCreatedBy(account);
		Company company=new Company();
		company.setCompanyName("Mesa");
		development.setDealType("Equity");
		development.setName("Mesa Cengelkoy");
		development.setStatus("Pending");
		development.setPrice(5000000d);
		development.setPercentage(10);
		development.setTotalInvestor(0);
		developmentList.add(development);
		
		 development=new Development();
		
		 account=new Account();
		account.setFirstName("Agaoglu");
		account.setLastName("Admin");
		 company=new Company();
		company.setCompanyName("Agaoglu");
		development.setCreatedBy(account);
		
		development.setDealType("Equity");
		development.setName("Maslak 1453");
		development.setStatus("Pending");
		development.setPrice(5000000d);
		development.setPercentage(10);
		development.setTotalInvestor(0);
		
		
		developmentList.add(development);
		
	}

	public List<Development> getDevelopmentList() {
		return developmentList;
	}

	public void setDevelopmentList(List<Development> developmentList) {
		this.developmentList = developmentList;
	}

	public List<Development> getFilteredDevelopmentList() {
		return filteredDevelopmentList;
	}

	public void setFilteredDevelopmentList(List<Development> filteredDevelopmentList) {
		this.filteredDevelopmentList = filteredDevelopmentList;
	}


}
