package com.camlait.global.erp.domain.exception;

/**
 * Generic runtime exception that occurs when something goes wrong during the
 * storage process.
 * 
 * @author Martin Blaise Signe
 *
 */
@SuppressWarnings("serial")
public class DataStorageExcetion extends RuntimeException {

	public DataStorageExcetion(String message) {
		super(message);
	}

	public DataStorageExcetion(String message, Throwable cause) {
		super(message, cause);
	}

	public DataStorageExcetion(Throwable cause) {
		super(cause);
	}
}
