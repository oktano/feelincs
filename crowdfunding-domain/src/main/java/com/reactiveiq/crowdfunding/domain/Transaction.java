package com.reactiveiq.crowdfunding.domain;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name="TRANSACTION")
public class Transaction extends BaseEntity{

	private Development development;
	
	private Account investor;
	
	private double invesmentAmount;
	
	private String currency;
	
	private Date dateJoined;
	
	private Boolean status;
	

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DEVELOPMENT_ID")	
	public Development getDevelopment() {
		return development;
	}

	public void setDevelopment(Development development) {
		this.development = development;
	}

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="INVESTOR_ID")	
	public Account getInvestor() {
		return investor;
	}

	public void setInvestor(Account investor) {
		this.investor = investor;
	}

	@Column(name="INVESTMENT_AMOUNT")
	public double getInvesmentAmount() {
		return invesmentAmount;
	}

	public void setInvesmentAmount(double invesmentAmount) {
		this.invesmentAmount = invesmentAmount;
	}

	@Column(name="CURRENCY")
	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	@Column(name="DATE_JOINED")
	@Temporal(TemporalType.DATE)
	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}

	@Column(name="STATUS")
	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}


	
}
