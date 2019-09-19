package com.staff_management_system;

/**
 * HourlyEmployee Not Found Exception class
 */
public class NotFoundException extends Exception {

    public NotFoundException() {
        super();
    }


    //@param message the message of the exception thrown

    public NotFoundException(String message) {
        super(message);
    }
}
