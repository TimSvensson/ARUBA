/*
 * Project: ARUBA 
 * Class:   RoutingResponsErrorsException
 *
 * Version info
 * Created: 04/05/17
 * Creator: Tim Svensson
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.ARUBAExceptions;

/**
 * If the result from either the Geocoding or Directions classes has errors in their results,
 * this exception is thrown.
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class HasErrorsException extends Exception{

    public HasErrorsException() {}

    public HasErrorsException(String message) {
        super(message);
    }

    public HasErrorsException(String message, Throwable cause) {
        super(message, cause);
    }

    public HasErrorsException(Throwable cause) {
        super(cause);
    }
}
