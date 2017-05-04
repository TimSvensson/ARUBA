/*
 * Project: ARUBA 
 * Class:   ModeOfTransportException
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
 * Class summary.
 * <p>
 * Class Description.
 * </p>
 *
 * @author Tim Svensson <tim.svensson@fasbros.it>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class ModeOfTransportException extends Exception {

    public ModeOfTransportException() {
    }

    public ModeOfTransportException(String message) {
        super(message);
    }

    public ModeOfTransportException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModeOfTransportException(Throwable cause) {
        super(cause);
    }
}
