package com.reactiveiq.crowdfunding.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="LOCALE_VALUE")
public class LocaleValue extends BaseEntity {

	private String language;
	
	private String value;
	
	private LookupData lookupData;

	@Column(name="LANG_CODE")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}


	@Column(name="VALUE")	
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="LOOKUP_DATA_ID")		
	public LookupData getLookupData() {
		return lookupData;
	}

	public void setLookupData(LookupData lookupData) {
		this.lookupData = lookupData;
	}
	
}
