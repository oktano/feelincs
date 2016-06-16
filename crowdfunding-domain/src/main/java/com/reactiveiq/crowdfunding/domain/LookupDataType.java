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
	
	private String displayValue;
	
	private boolean hasImage;
	
	private boolean hasType;

	private List<LookupData>lookupDataList;
	
	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL,mappedBy="lookupDataType")	
	public List<LookupData> getLookupDataList() {
		return lookupDataList;
	}

	public void setLookupDataList(List<LookupData> lookupDataList) {
		this.lookupDataList = lookupDataList;
	}
	

	@Column(name="NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name="DISPLAY_VALUE")
	public String getDisplayValue() {
		return displayValue;
	}

	public void setDisplayValue(String displayValue) {
		this.displayValue = displayValue;
	}

	@Column(name="HAS_IMAGE")
	public boolean isHasImage() {
		return hasImage;
	}

	public void setHasImage(boolean hasImage) {
		this.hasImage = hasImage;
	}
	@Column(name="HAS_TYPE")
	public boolean isHasType() {
		return hasType;
	}

	public void setHasType(boolean hasType) {
		this.hasType = hasType;
	}
	
	
}
