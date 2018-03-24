/**
 * 
 */
package org.tsm.exception;

/**
 * @author shardaps
 *
 */
public class CacheServiceException extends RuntimeException {

    private static final long serialVersionUID = -8225120617128299135L;

    public CacheServiceException(String message) {
        super(message);
    }

    public CacheServiceException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public CacheServiceException(Throwable throwable) {
        super(throwable);
    }
}
