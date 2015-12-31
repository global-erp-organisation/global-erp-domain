package com.camlait.global.erp.domain.exception;

@SuppressWarnings("serial")
public class GlobalErpServiceException extends RuntimeException {

	public GlobalErpServiceException(String message) {
		super(message);
	}

	public GlobalErpServiceException(String message, Throwable cause) {
		super(message, cause);
	}
}
