package com.reactiveiq.crowdfunding.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOOKUP_DATA_TYPE")
public class LookupDataType  extends BaseEntity{

	private String name;
	

	private List<LookupData>lookupDataList;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="lookupDataType")	
	public List<LookupData> getLookupDataList() {
		return lookupDataList;
	}

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLookupDataList(List<LookupData> lookupDataList) {
		this.lookupDataList = lookupDataList;
	}
}
