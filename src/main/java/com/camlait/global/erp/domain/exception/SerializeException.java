package com.camlait.global.erp.domain.exception;

@SuppressWarnings("serial")
public class SerializeException extends RuntimeException {

	public SerializeException(String message) {
		super(message);
	}

	public SerializeException(String message, Throwable cause) {
		super(message, cause);
	}

	public SerializeException(Throwable cause) {
		super(cause);
	}
}
