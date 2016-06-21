package com.reactiveiq.crowdfunding.util;


import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 * Error handler for invalid requests
 * @author ksuicmez
 *
 */
public class ErrorHandler {

	public static void catch404Error(){
		try{
			 ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			 ec.redirect(ec.getRequestContextPath() + "/404.html");
		}
		catch(Exception ex){
			ex.printStackTrace();
		}
		
	}
}
