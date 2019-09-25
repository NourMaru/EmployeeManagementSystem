package com.exceptions;

public class InvalidUserDataException extends Exception {

    //code used to remove the Java generate warning
    private static final long serialVersionUID = 1L;

    //@param message the message of the exception thrown
    public InvalidUserDataException(String message) {
        super(message);
    }

    //Invalid Id Exception
    public InvalidUserDataException() {
        super();
    }
}
