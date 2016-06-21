package com.reactiveiq.crowdfunding.web.utils;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Error handler for invalid requests
 * @author ksuicmez
 *
 */
public class ErrorHandler {

	private static Logger LOGGER=LoggerFactory.getLogger(ErrorHandler.class.getName()) ;
	
	public static void catch404Error(){
		try{
			 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			 ec.redirect(ec.getRequestContextPath() + "/404.html");
		}
		catch(Exception ex){
			LOGGER.error("Exception occured while redirecting page",ex);
		}
		
	}
}
