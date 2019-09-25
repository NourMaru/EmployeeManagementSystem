package com.exceptions;

/**
 * Invalid HourlyEmployee Name Exception class that extends Exception
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */
public class InvalidNameException extends Exception {

    //code used to remove the Java generate warning
    private static final long serialVersionUID = 1L;

    //@param message the message of the exception thrown
    public InvalidNameException(String message) {
        super(message);
    }

    //Invalid Id Exception
    public InvalidNameException() {
        super();
    }
}
