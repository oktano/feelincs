package com.reactiveiq.crowdfunding.service.validation;
import javax.inject.Singleton;
import javax.validation.ValidationException;

import org.apache.commons.validator.routines.EmailValidator;

import com.reactiveiq.crowdfunding.domain.Account;

@Singleton
public class AccountCreationValidation implements ValidationI<Account> {

	private EmailValidator emailValidator=EmailValidator.getInstance();
	
	public void validate(Account account) throws ValidationException {
		if(account.getFirstName()==null || account.getFirstName().length()==0){
			throw new ValidationException("error.validation.account.fistname");
		}
		if(account.getLastName()==null || account.getLastName().length()==0){
			throw new ValidationException("error.validation.account.lastname");		
		}
				
		if(account.getUserName()==null || account.getUserName().length()==0 || !emailValidator.isValid(account.getUserName())){
			throw new ValidationException("error.validation.account.email");		
		}

		if(account.getPassword()==null || account.getPassword().length()==0 ){
			throw new ValidationException("error.validation.account.password");		
		}


	}

}