package com.exceptions;

public class InvalidPasswordException extends Exception {
    /**
     * code used to remove the Java generate warning
     */
    private static final long serialVersionUID = 1L;

    /**
     * @param message the message of the exception thrown
     */
    public InvalidPasswordException(String message) {
        super(message);
    }

    /**
     * Invalid Id Exception
     */
    public InvalidPasswordException() {
        super();
    }
}
