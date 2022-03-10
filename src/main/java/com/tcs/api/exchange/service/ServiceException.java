package com.tcs.api.exchange.service;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -465826325037486061L;
	private boolean swCustom;
	
	
	public ServiceException() {
		super();
	}
	
	
	public ServiceException(boolean swCustom,String message) {
		super(message);
		this.setSwCustom(swCustom);
	}
	
	
	public ServiceException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

}
