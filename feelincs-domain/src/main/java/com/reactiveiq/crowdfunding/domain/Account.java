package com.reactiveiq.crowdfunding.domain;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name="ACCOUNT")
public class Account extends BaseEntity implements Serializable{
	
	
	private Date registrationDate;
	
	private Date modifiedDate;
	
	private String userName;
	
	private String password;
	
	private String phoneNumber;
	
	private String passwordConfirmation;
	
	private String firstName;
	
	private String lastName;
	
	private String comfirmationCode;
	
	private Date lastLoginDateTime;
	
	private List<UserRole> currentRoles=new ArrayList<UserRole>();
	

	private AccountStatus accountStatus;
	
	@Column(name="PHONE_NUMBER",nullable=true,length=15)
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="USER_NAME",nullable=false,length=30)
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
	@Column(name="PASSWORD",nullable=false,length=64)
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(fetch=FetchType.LAZY,cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_ID")
	public List<UserRole> getCurrentRoles() {
		return currentRoles;
	}
	public void setCurrentRoles(List<UserRole> currentRoles) {
		this.currentRoles = currentRoles;
	}
	
	
	
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="ACCOUNT_STATUS")	
	public AccountStatus getAccountStatus() {
		return accountStatus;
	}
	public void setAccountStatus(AccountStatus accountStatus) {
		this.accountStatus = accountStatus;
	}

	
	@Column(name="REGISTRATION_DATE",nullable=false)
	@Temporal(TemporalType.DATE)
	public Date getRegistrationDate() {
		return registrationDate;
	}
	public void setRegistrationDate(Date registrationDate) {
		this.registrationDate = registrationDate;
	}
	
	@Column(name="MODIFIED_DATE")
	@Temporal(TemporalType.DATE)	
	public Date getModifiedDate() {
		return modifiedDate;
	}
	
	
	
	public void setModifiedDate(Date modifiedDate) {
		this.modifiedDate = modifiedDate;
	}
		
	@Column(name="CONFIRMATION_CODE")	
	public String getComfirmationCode() {
		return comfirmationCode;
	}

	public void setComfirmationCode(String comfirmationCode) {
		this.comfirmationCode = comfirmationCode;
	}
	
	@Column(name="FIRST_NAME",length=20)	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="LAST_NAME",length=20)		
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
		
	@Transient
	public String getFullName(){
		return getFirstName()+" "+this.getLastName();
	}
	
	@Transient
	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}
		
	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
	}
	
	@Column(name="LAST_LOGIN_DATE")
	@Temporal(TemporalType.DATE)	
	public Date getLastLoginDateTime() {
		return lastLoginDateTime;
	}
	public void setLastLoginDateTime(Date lastLoginDateTime) {
		this.lastLoginDateTime = lastLoginDateTime;
	}
	
	

}
