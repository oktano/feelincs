package com.reactiveiq.crowdfunding.domain;

import java.util.ArrayList;
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
@Table(name="COMPANY")
public class Company extends BaseEntity {

	private String companyName;
	
	private Integer yearFounded;
	
	private LookupData category;
	
	private Address address;
	
	private Double totalAssetUnderManagement;
	
	private double totalAreaDeveloped;
	
	private String companyOverview;
	 	
	
	private List<Development> developments=	new ArrayList<Development>();

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="company")	
	public List<Development> getDevelopments() {
		return developments;
	}

	public void setDevelopments(List<Development> developments) {
		this.developments = developments;
	}

	@Column(name="COMPANY_NAME")
	public String getCompanyName() {
		return companyName;
	}

	
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	@Column(name="YEAR_FOUNDED")
	public Integer getYearFounded() {
		return yearFounded;
	}

	public void setYearFounded(Integer yearFounded) {
		this.yearFounded = yearFounded;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="COMPANY_CATEGORY_ID")	
	public LookupData getCategory() {
		return category;
	}

	public void setCategory(LookupData category) {
		this.category = category;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ADDRESS_ID")	
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}
	
	@Column(name="TOTAL_ASSET_UNDER_MNGT")
	public Double getTotalAssetUnderManagement() {
		return totalAssetUnderManagement;
	}

	public void setTotalAssetUnderManagement(Double totalAssetUnderManagement) {
		this.totalAssetUnderManagement = totalAssetUnderManagement;
	}

	@Column(name="TOTAL_AREA_DEVELOPED")	
	public double getTotalAreaDeveloped() {
		return totalAreaDeveloped;
	}

	public void setTotalAreaDeveloped(double totalAreaDeveloped) {
		this.totalAreaDeveloped = totalAreaDeveloped;
	}

	@Column(name="COMPANY_OVERVIEW")
	public String getCompanyOverview() {
		return companyOverview;
	}

	public void setCompanyOverview(String companyOverview) {
		this.companyOverview = companyOverview;
	}


}
