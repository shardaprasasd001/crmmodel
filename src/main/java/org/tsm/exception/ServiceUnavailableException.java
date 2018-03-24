package org.tsm.exception;

public class ServiceUnavailableException extends RuntimeException{

    private static final long serialVersionUID = -8245675064165854489L;

    public ServiceUnavailableException(String message) {
        super(message);
    }

    public ServiceUnavailableException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ServiceUnavailableException(Throwable throwable) {
        super(throwable);
    }
}