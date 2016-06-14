package com.reactiveiq.crowdfunding.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


@Entity
@Table(name="DOCUMENT")
public class Document extends BaseEntity {
	
	
	private String fileName;
	
	private Development development;
	

	@Column(name="FILE_NAME",length=100)
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@OneToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="DEVELOPMENT_ID")		
	public Development getDevelopment() {
		return development;
	}

	public void setDevelopment(Development development) {
		this.development = development;
	}

	
}
