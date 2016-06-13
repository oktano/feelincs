package com.reactiveiq.crowdfunding.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="DOCUMENT")
public class Document extends BaseEntity {
	
	
	private String fileName;
	
	private LookupData documentType;

	private Property property;
	

	@Column(name="FILE_NAME",length=100)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}


	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DOCUMENT_TYPE_ID")	
	public LookupData getDocumentType() {
		return documentType;
	}

	public void setDocumentType(LookupData documentType) {
		this.documentType = documentType;
	}

	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="PROPERTY_ID")		
	public Property getProperty() {
		return property;
	}

	public void setProperty(Property property) {
		this.property = property;
	}

	
}
