package com.reactiveiq.crowdfunding.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

@Entity
@Table(name="LOOKUP_DATA")
public class LookupData extends BaseEntity{

	private LookupDataType lookupDataType;
	
	private String value;
	
	private String language;

	private String imageFile;
	
	private String type;
	
	private String description;

	
	@ManyToOne
	@Cascade(CascadeType.SAVE_UPDATE)
	@JoinColumn(name="DATA_TYPE_ID")	
	public LookupDataType getLookupDataType() {
		return lookupDataType;
	}

	public void setLookupDataType(LookupDataType lookupDataType) {
		this.lookupDataType = lookupDataType;
	}

	
	@Column(name="VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	@Column(name="LANGUAGE")
	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	@Column(name="IMAGE_FILE")
	public String getImageFile() {
		return imageFile;
	}

	public void setImageFile(String imageFile) {
		this.imageFile = imageFile;
	}

	@Column(name="TYPE")
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@Column(name="DESCRIPTION")
	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
	
}
