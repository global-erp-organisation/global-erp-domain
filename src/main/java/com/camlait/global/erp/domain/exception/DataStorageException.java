package com.camlait.global.erp.domain.exception;

/**
 * Generic runtime exception that occurs when something goes wrong during the
 * storage process.
 * 
 * @author Martin Blaise Signe
 *
 */
@SuppressWarnings("serial")
public class DataStorageException extends RuntimeException {

	public DataStorageException(String message) {
		super(message);
	}

	public DataStorageException(String message, Throwable cause) {
		super(message, cause);
	}

	public DataStorageException(Throwable cause) {
		super(cause);
	}
}
