/*
 * Project: ARUBA 
 * Class:   GoogleNoResultsException
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
 * Thrown when there's no results from any of the Directions or Geocodeing classes.
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class NoResultsException extends Exception {

    public NoResultsException() {
    }

    public NoResultsException(String message) {
        super(message);
    }

    public NoResultsException(String message, Throwable cause) {
        super(message, cause);
    }

    public NoResultsException(Throwable cause) {
        super(cause);
    }
}