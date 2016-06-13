package com.reactiveiq.crowdfunding.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="DOCUMENT")
public class LookupDataType  extends BaseEntity{

	private String type;
	
	private List<LookupData>lookupDataList;

	@Column(name="TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="lookupDataType")	
	public List<LookupData> getLookupDataList() {
		return lookupDataList;
	}

	public void setLookupDataList(List<LookupData> lookupDataList) {
		this.lookupDataList = lookupDataList;
	}

}
