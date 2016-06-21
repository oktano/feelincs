package com.reactiveiq.crowdfunding.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="ACCOUNT_STATUS")
public class AccountStatus implements Serializable{

	private boolean isAccountEnabled=false;

	private boolean isAccountExpired;
	
	private boolean isCredentialsExpired;
	
	private boolean isAccountLocked;
	
	private Long id;
	
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="ID")
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	@Column(name="IS_ACCOUNT_ENABLED")	
	public boolean isAccountEnabled() {
		return isAccountEnabled;
	}
	public void setAccountEnabled(boolean isAccountEnabled) {
		this.isAccountEnabled = isAccountEnabled;
	}

	@Column(name="IS_ACCOUNT_EXPIRED")	
	public boolean isAccountExpired() {
		return isAccountExpired;
	}
	public void setAccountExpired(boolean isAccountExpired) {
		this.isAccountExpired = isAccountExpired;
	}
	
	@Column(name="IS_CREDENDIALS_EXPIRED")		
	public boolean isCredentialsExpired() {
		return isCredentialsExpired;
	}
	public void setCredentialsExpired(boolean isCredentialsExpired) {
		this.isCredentialsExpired = isCredentialsExpired;
	}
	
	@Column(name="IS_ACCOUNT_LOCKED")		
	public boolean isAccountLocked() {
		return isAccountLocked;
	}
	public void setAccountLocked(boolean isAccountLocked) {
		this.isAccountLocked = isAccountLocked;
	}
	
}
