/*
 * Project: ARUBA 
 * Class:   ARUBAExceptions
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
 * Exception thrown when the Directions, or Geocoding classes detect that there are no Agents in
 * there input.
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class NoAgentsException extends Exception {

    public NoAgentsException() {}

    public NoAgentsException(String message) {
        super(message);
    }

    public NoAgentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAgentsException(Throwable cause) {
        super(cause);
    }
}
