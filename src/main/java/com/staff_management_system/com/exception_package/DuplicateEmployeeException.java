package com.exception_package;

/**
 * Duplicate HourlyEmployee Exception Class
 */
public class DuplicateEmployeeException extends Exception {

    private static final long serialVersionUID = 1L;


    //@param message the message of the exception thrown

    public DuplicateEmployeeException(String message) {
        super(message);
    }

}
