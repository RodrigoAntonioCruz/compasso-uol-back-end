package com.compasso.api.services.exceptions;

/**
*
* @author Rodrigo da Cruz
* @version 1.0
* @since 2021-02-05
* 
*/

public class EntityNotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = 1L;
	
	public EntityNotFoundException(String msg) {
		super(msg);
	}

}
