package com.reactiveiq.crowdfunding.domain;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="COMPANY")
public class Company extends BaseEntity {

	private String companyName;
	
	
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
	

}
