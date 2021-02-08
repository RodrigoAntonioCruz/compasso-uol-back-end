package com.compasso.api.services.exceptions;

/**
*
* @author Rodrigo da Cruz
* @version 1.0
* @since 2021-02-06
* 
*/

public class EntityValidationException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EntityValidationException(String msg) {
		super(msg);
	}

}
