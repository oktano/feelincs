package com.reactiveiq.crowdfunding.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="PROPERTY")
public class Property  extends BaseEntity{

	private String description;
	
	private Address address;	
	
	private double price;
	
	private List<Document>documents;
	
	private float sponsorEquitySharePercentage;

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

	@OneToMany(cascade=CascadeType.ALL,mappedBy="property")	
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

	
	
}
