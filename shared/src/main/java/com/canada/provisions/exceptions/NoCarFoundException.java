/**
 * 
 */
package com.canada.provisions.exceptions;

/**
 * @author MENAD
 *custom exception which should be thrown whenever an isntance is not found
 */
public class NoCarFoundException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NoCarFoundException(String message) {
		super(message);
	}

}
