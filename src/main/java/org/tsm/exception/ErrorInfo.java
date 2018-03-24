/**
 * 
 */
package org.tsm.exception;

import java.io.Serializable;

/**
 * @author shardaps
 *
 */
public class ErrorInfo implements Serializable {

    private static final long serialVersionUID = -5408627893841642295L;

    private String message;
    private String uri;

    public ErrorInfo() {
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }
}
