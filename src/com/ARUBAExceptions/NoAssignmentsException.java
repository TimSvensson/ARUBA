/*
 * Project: ARUBA 
 * Class:   NoAssignmentsException
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
 * Thrown when no assignment has been detected in the input of any of the Directions classes.
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class NoAssignmentsException extends Exception {

    public NoAssignmentsException() {
    }

    public NoAssignmentsException(String message) {
        super(message);
    }

    public NoAssignmentsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAssignmentsException(Throwable cause) {
        super(cause);
    }
}
