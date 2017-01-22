package com.camlait.global.erp.domain.exception;

@SuppressWarnings("serial")
public class LazyInitException extends RuntimeException {

    public LazyInitException(String message) {
        super(message);
    }

    public LazyInitException(String message, Throwable cause) {
        super(message, cause);
    }

    public LazyInitException(Throwable cause) {
        super(cause);
    }
}
