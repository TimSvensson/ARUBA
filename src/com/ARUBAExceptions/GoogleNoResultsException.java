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
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Haubir Mariwani <haubir.mariwani@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class GoogleNoResultsException extends Exception {

    public GoogleNoResultsException() {
    }

    public GoogleNoResultsException(String message) {
        super(message);
    }

    public GoogleNoResultsException(String message, Throwable cause) {
        super(message, cause);
    }

    public GoogleNoResultsException(Throwable cause) {
        super(cause);
    }
}