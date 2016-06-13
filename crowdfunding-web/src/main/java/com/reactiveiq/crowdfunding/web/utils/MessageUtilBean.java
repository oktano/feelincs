package com.reactiveiq.crowdfunding.web.utils;

import java.text.MessageFormat;
import java.util.Hashtable;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.faces.application.FacesMessage;
import javax.faces.application.FacesMessage.Severity;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;



@Named("messageUtilBean")
@ApplicationScoped
public  class MessageUtilBean {


    private static Logger log=Logger.getLogger(MessageUtilBean.class.getName()) ;
	
	private static final String BASE_NAME = "messages";

	private static Hashtable<Locale, ResourceBundle> bundles = new Hashtable<Locale, ResourceBundle>();

	/**
	 * Returns a String message representing the error code provided.
	 * <p>
	 * If an exception is thrown, this method will return <tt>null</tt>
	 * 
	 * @param key
	 *        Error Code/Number
	 * @return String error message derived from <code>key</code>.
	 */
	public  static String getMessage(String key) {
		return getMessage(key, null, (Object[]) null);
	}

	/**
	 * Returns a String message representing the error code provided.
	 * <p>
	 * If an exception is thrown, this method will return <tt>null</tt>
	 * 
	 * @param key
	 *        Error Code/Number
	 * @param args
	 *        The objects to format
	 * @return String error message derived from <code>key</code>.
	 */
	
	public  static String getMessage(String key, Object...args) {
		return getMessage(key, null, args);
	}
	
	public static String getLabel(String key, String arg) {
		return getMessage(key, null, arg);
	}


	public static String getLabelForPriceRange(String key, String arg1,String arg2) {
		return getMessage(key, null, arg1,arg2);
	}

	/**
	 * Returns a String message, respective to the provided locale, representing
	 * the error code (number) provided.
	 * <p>
	 * If an exception is thrown, this method will return <tt>null</tt>
	 * 
	 * @param key
	 *        Error Code/Number
	 * @param args
	 *        The objects to format
	 * @param locale
	 *        Locale to be used for translating the message.
	 * @return String error message derived from <code>key</code>.
	 */
	public static  String getMessage(String key, Locale locale, Object... args) {
		try {
			String msg = getBundle(locale).getString(key);
			if (args != null) {
				MessageFormat msgFormat = new MessageFormat(msg);
				msg = msgFormat.format(args);
			}
			return msg;
		} catch (Exception e) {
			log.log(Level.SEVERE,e.getMessage(), e);
		}
		return null;
	}

	private  static ResourceBundle getBundle(Locale locale) throws Exception {
		if (locale == null) {
			FacesContext facesContext = FacesContext.getCurrentInstance();
			ExternalContext externalContext = (facesContext!=null) ? facesContext.getExternalContext() : null;
			if (externalContext != null) {
				locale = facesContext.getViewRoot().getLocale();
			} else {
				locale = Locale.getDefault();
			}
		}

		ResourceBundle bundle = (ResourceBundle) bundles.get(locale);
		try {
			if (bundle == null) {
				bundle = ResourceBundle.getBundle(BASE_NAME, locale);
				bundles.put(locale, bundle);
			}
		} catch (MissingResourceException e) {
			log.log(Level.SEVERE,e.getMessage(), e);
		}
		return bundle;
	}

	/**
	 * Returns an <tt>FacesMessage</tt> derived from the error code provided.
	 * <p>
	 * If an exception is thrown, this method will return <tt>null</tt>
	 * 
	 * @param key
	 *        Error Code/Number
	 * @param severity
	 *        The severity of the message
	 * @return An FacesMessage derived from <code>key</code>.
	 */
	public  static FacesMessage getFacesMessage(String key, Severity severity) {
		return getFacesMessage(key, severity, (Object[]) null);
	}

	/**
	 * Returns an <tt>FacesMessage</tt> derived from the error code provided.
	 * <p>
	 * If an exception is thrown, this method will return <tt>null</tt>
	 * 
	 * @param key
	 *        Error Code/Number
	 * @param args
	 *        The objects to format
	 * @param severity
	 *        The severity of the message
	 * @return An FacesMessage derived from <code>key</code>.
	 */
	public static  FacesMessage getFacesMessage(String key, Severity severity, Object... args) {
		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(severity);
		facesMessage.setSummary(getMessage(key, args));
		facesMessage.setDetail(getMessage(key, args));
		return facesMessage;
	}

	
	public  static FacesMessage getFacesMessage(String message) {
		FacesMessage facesMessage = new FacesMessage();
		facesMessage.setSeverity(FacesMessage.SEVERITY_ERROR);
		facesMessage.setSummary(message);
		facesMessage.setDetail(message);
		return facesMessage;
	}

}