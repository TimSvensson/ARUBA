/*
 * Project: ARUBA 
 * Class:   NoResultsException
 *
 * Version info
 * Created: 5/7/17
 * Creator: Haubir Mariwani
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given explicit permission.
 */

package com.ARUBAExceptions;

/**
 * NoResultsException
 *
 * <p>
 * Whenever an API doesn't find any results, a NoResulstsExcpetion is thrown.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class NoResultsException extends Exception {

    /**
     * Empty constructor.
     */
    public NoResultsException() {}

    /**
     * Constructor with message.
     *
     * @param message
     */
    public NoResultsException(String message) {
        super(message);
    }

    /**
     * Constructor with message and throwable cause.
     *
     * @param message
     * @param cause
     */
    public NoResultsException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with throwable cause.
     *
     * @param cause
     */
    public NoResultsException(Throwable cause) {
        super(cause);
    }
}