package com.reactiveiq.crowdfunding.service.validation;
import javax.validation.ValidationException;


public interface ValidationI<T> {

	public void validate(T value)
		throws ValidationException;
		
}