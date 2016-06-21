package com.reactiveiq.crowdfunding.util;



import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.enterprise.inject.spi.CDI;

public class CdiBeanUtil {

	public static <T> T getBean(Class<T>clazz){
		
		BeanManager bm = CDI.current().getBeanManager();
		
		Bean<T> bean = (Bean<T>) bm.getBeans(clazz).iterator().next();
		CreationalContext<T> ctx = bm.createCreationalContext(bean);
		T service = (T) bm.getReference(bean, clazz, ctx);	
		return service;
	}
}
