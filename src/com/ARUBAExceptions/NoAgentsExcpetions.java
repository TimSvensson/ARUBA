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

import java.io.IOException;

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
public class NoAgentsExcpetions extends Exception {

    public NoAgentsExcpetions() {
    }

    public NoAgentsExcpetions(String message) {
        super(message);
    }

    public NoAgentsExcpetions(String message, Throwable cause) {
        super(message, cause);
    }

    public NoAgentsExcpetions(Throwable cause) {
        super(cause);
    }
}
