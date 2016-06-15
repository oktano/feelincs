package com.reactiveiq.crowdfunding.domain;


import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
@Table(name="ADDRESS")
public class Address extends BaseEntity{
	
	
	private String country;
	
	private String emailAddress;

	private String city;
	
	private String route;
	
	private String state;
		
	private String postalCode;
	
	private String streetAddress;
	
    private String streetNumber;

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getRoute() {
		return route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getStreetNumber() {
		return streetNumber;
	}

	public void setStreetNumber(String streetNumber) {
		this.streetNumber = streetNumber;
	}

	@Override
	public String toString() {
		return "Address [country=" + country + ", city=" + city + ", route=" + route + ", state=" + state
				+ ", postalCode=" + postalCode + ", streetAddress=" + streetAddress + ", streetNumber=" + streetNumber
				+ "]";
	} 
	


}
