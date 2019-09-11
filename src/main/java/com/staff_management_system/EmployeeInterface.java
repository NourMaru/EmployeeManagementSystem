package com.staff_management_system;

/**
 * Interface EmployeeInterface that includes constants and a method for the package.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */

public interface EmployeeInterface {

    /**
     * The default company name shared variable
     */
    String COMPANY_NAME = "=== COMPANY ===";

    /**
     * The default phone number shared variable
     */
    long PHONE_NUMBER = 6475294336L;

    /**
     *    The default minimum id number shared variable
     */
    int MINIMUM_ID_NUMBER = 100000;

    /**
     *    The default maximum id number shared variable
     */
    int MAXIMUM_ID_NUMBER = 999999;


    /**
     * @return public method header for a method called getTypeForDisplay() that takes no arguments
     * and returns a String.
     */
    String getTypeForDisplay();
}
