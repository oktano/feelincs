package com.reactiveiq.crowdfunding.service;

import java.io.Serializable;

public class AccountSearchDto implements Serializable {

	private String  searchField;

	public String getSearchField() {
		return searchField;
	}

	public void setSearchField(String searchField) {
		this.searchField = searchField;
	}
	
	
}
