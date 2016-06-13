package com.reactiveiq.crowdfunding.common;

import java.io.Serializable;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;

@SessionScoped
public class LocaleCurrencyManager implements Serializable{
			
	private String currency;	
	private String locale;
	private String country;
	
	
	public void setLocale(String locale) {
	
		this.locale=locale;
		FacesContext.getCurrentInstance().getViewRoot().setLocale(Locale.forLanguageTag(locale));
		
	}	
	
	
	@PostConstruct
	private void init(){
		setLocale("en");
		setCurrency("CND");
		setCountry("CA");
	}

	
	public String getLocale(){
		return locale;
	}


	public String getCurrency() {
		return currency;
	}


	public void setCurrency(String currency) {
		this.currency = currency;
	}


	public String getCountry() {
		return country;
	}


	public void setCountry(String country) {
		this.country = country;
	}

	
}
