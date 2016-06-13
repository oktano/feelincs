package com.reactiveiq.crowdfunding.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="LOOKUP_DATA")
public class LookupData extends BaseEntity{

	private LookupDataType lookupDataType;
	
	private String language;
	
	private List<LocaleValue>localeValueList;

	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DATA_TYPE_ID")	
	public LookupDataType getLookupDataType() {
		return lookupDataType;
	}

	public void setLookupDataType(LookupDataType lookupDataType) {
		this.lookupDataType = lookupDataType;
	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@OneToMany(cascade=CascadeType.ALL,mappedBy="lookupData")	
	public List<LocaleValue> getLocaleValueList() {
		return localeValueList;
	}

	public void setLocaleValueList(List<LocaleValue> localeValueList) {
		this.localeValueList = localeValueList;
	}
	
}
