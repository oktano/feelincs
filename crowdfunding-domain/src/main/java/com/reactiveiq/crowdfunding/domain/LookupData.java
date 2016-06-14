package com.reactiveiq.crowdfunding.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOOKUP_DATA")
public class LookupData extends BaseEntity{

	private LookupDataType lookupDataType;
	
	private String name;
	
	private String language;
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DATA_TYPE_ID")	
	public LookupDataType getLookupDataType() {
		return lookupDataType;
	}

	public void setLookupDataType(LookupDataType lookupDataType) {
		this.lookupDataType = lookupDataType;
	}

	
	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="LANG_CODE")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	
}
