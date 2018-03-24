/**
 * 
 */
package org.tsm.exception;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.httpclient.auth.InvalidCredentialsException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;





/**
 * @author shardaps
 *
 */

@ControllerAdvice
public class CustomizedResponseExceptionHandler {
	
	@ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ErrorInfo> handleIllegalArgException(HttpServletRequest httpServletReq, Exception exception) {
        return getErrorInfoResponseEntity(httpServletReq, exception, HttpStatus.BAD_REQUEST);
    }
	
	@ExceptionHandler(InvalidCredentialsException.class)
    public ResponseEntity<ErrorInfo> handleUnAuthUser(HttpServletRequest httpServletReq, Exception exception) {
        return getErrorInfoResponseEntity(httpServletReq, exception, HttpStatus.FORBIDDEN);
    }
	
	 @ExceptionHandler(ServiceUnavailableException.class)
	    public ResponseEntity<ErrorInfo> handleResourceAccessException(HttpServletRequest httpServletReq,
	            Exception exception) {
	        return getErrorInfoResponseEntity(httpServletReq, exception, HttpStatus.BAD_GATEWAY);
	    }

	private ResponseEntity<ErrorInfo> getErrorInfoResponseEntity(HttpServletRequest httpServletReq, Exception exception,
            HttpStatus httpStatus) {
        ErrorInfo error = new ErrorInfo();
        error.setMessage(exception.getLocalizedMessage());
        error.setUri(httpServletReq.getRequestURI());
        return new ResponseEntity<ErrorInfo>(error, httpStatus);
    }

}
