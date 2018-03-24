/**
 * 
 */
package org.tsm.exception;

/**
 * @author shardaps
 *
 */
public class ObjectNotFoundException extends RuntimeException {

    private static final long serialVersionUID = -157417501220281966L;

    public ObjectNotFoundException(String message) {
        super(message);
    }

    public ObjectNotFoundException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ObjectNotFoundException(Throwable throwable) {
        super(throwable);
    }
}
