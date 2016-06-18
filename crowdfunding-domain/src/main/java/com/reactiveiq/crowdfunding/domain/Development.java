package com.reactiveiq.crowdfunding.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="DEVELOPMENT")
public class Development  extends BaseEntity{

	private String name;
	
	private Company company;
	
	private String description;
	
	private Address address;	
	
	private double price;
	
	private List<Document>documents;
	
	private float sponsorEquitySharePercentage;
	
	private String dealType;
	
	private Account createdBy;

	private Integer percentage;

	private Integer totalInvestor;
	
	private String status;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="COMPANY_ID")		
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company= company;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Column(name="PRICE")
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="development")	
	public List<Document> getDocuments() {
		return documents;
	}

	public void setDocuments(List<Document> documents) {
		this.documents = documents;
	}

	@Column(name="SPONSOR_EQUITY_SHARE_PER")	
	public float getSponsorEquitySharePercentage() {
		return sponsorEquitySharePercentage;
	}

	public void setSponsorEquitySharePercentage(float sponsorEquitySharePercentage) {
		this.sponsorEquitySharePercentage = sponsorEquitySharePercentage;
	}

	@Column(name="NAME")	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDealType() {
		return dealType;
	}

	public void setDealType(String dealType) {
		this.dealType = dealType;
	}


	public Integer getPercentage() {
		return percentage;
	}

	public void setPercentage(Integer percentage) {
		this.percentage = percentage;
	}

	public Integer getTotalInvestor() {
		return totalInvestor;
	}

	public void setTotalInvestor(Integer totalInvestor) {
		this.totalInvestor = totalInvestor;
	}

	public Account getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Account createdBy) {
		this.createdBy = createdBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	
	
}
