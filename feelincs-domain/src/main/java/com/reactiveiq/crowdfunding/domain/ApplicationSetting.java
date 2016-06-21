package com.reactiveiq.crowdfunding.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name="APPLICATION_SETTING")
public class ApplicationSetting extends BaseEntity {

	private String key;
	
	private String value;

	@Column(name="NAME")
	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	@Column(name="VALUE")
	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}
	
}
