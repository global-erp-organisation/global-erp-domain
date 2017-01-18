package com.camlait.global.erp.domain.exception;

/**
 * Generic runtime exception that occurs when something goes wrong during the
 * object validation process.
 * 
 * @author Martin Blaise Signe.
 *
 */
@SuppressWarnings("serial")
public class DataValidationException extends RuntimeException {

	public DataValidationException(String message) {
		super(message);
	}

	public DataValidationException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataValidationException(Throwable cause) {
		super(cause);
	}

}
