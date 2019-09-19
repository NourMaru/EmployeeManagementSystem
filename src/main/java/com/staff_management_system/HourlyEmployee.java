package com.staff_management_system;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Date;


/**
 * Subclass HourlyEmployee that holds default and parameterized constructors with values.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */
public class HourlyEmployee extends User {

    //The employee's department instance variable
    private String department;

    /**
     * return the department attribute for employee
     *
     * @return the department
     */
    public String getDepartment() {
        return department;
    }

    /**
     * set the department attribute for the employee
     *
     * @param department the department to set
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * A parameterized constructor that accepts arguments for
     * the types corresponding to the listed attributes,
     * and places each argument into its appropriate
     * attribute using the setXxx() method
     *
     * @param id           the id for employee
     * @param password     the password for employee
     * @param firstName    the first name for employee
     * @param lastName     the last name for employee
     * @param role         the role for employee
     * @param startDate    the start date for employee
     * @param sin          the social insurance number for employee
     * @param phoneNumber  the phone number for employee
     * @param emailAddress the email address for employee
     * @param address      the address for employee
     * @param hourly       the hourly for employee
     * @param isEnabled    the enabled for employee
     * @param department   the department for employee
     * @throws InvalidEmployeeDataException this exception is thrown if the employees's data is invalid
     */
    public HourlyEmployee(int id, String password, String firstName, String lastName, String role,
                          Date startDate, String sin, long phoneNumber, String emailAddress,
                          String address, float hourly, boolean isEnabled, String department)
            throws InvalidEmployeeDataException {
        try {
            this.setId(id);
            this.setPassword(password);
            this.setFirstName(firstName);
            this.setLastName(lastName);
            this.setRole(role);
            this.setStartDate(startDate);
            this.setSin(sin);
            this.setPhoneNumber(phoneNumber);
            this.setEmailAddress(emailAddress);
            this.setAddress(address);
            this.setSalary(hourly);
            this.setEnabled(isEnabled);
            this.setDepartment(department);
        } catch (Exception e) {
            throw new InvalidEmployeeDataException(e.getMessage());
        }
    }

    public static boolean isExistingLogin(String id) {
        return HourlyEmployeeDataAccess.isExistingLogin(id);
    }

    public HourlyEmployee login(long id, String password) throws NotFoundException {
        return HourlyEmployeeDataAccess.login(id, password);
    }

    /**
     * @param id the employee's Id
     * @throws NotFoundException exception is thrown if the employee record not found
     */
    public HourlyEmployee retrieve(int id) throws NotFoundException {
        return HourlyEmployeeDataAccess.retrieve(id);
    }

    /**
     * HourlyEmployee public method header for a method called terminate()
     * that takes no arguments and calls employee
     */
    public void terminate() {
        HourlyEmployeeDataAccess.terminate();
    }

    /**
     * @param id
     * @return the employee's record as an instance of employee
     * @throws NotFoundException
     */
    public HourlyEmployee find(int id) throws NotFoundException {
        return HourlyEmployeeDataAccess.retrieve(id);
    }

    /**
     * initialize()
     * employee public method header for a method called initialize()
     * that takes connection arguments and calls employee
     */

    public void initialize(Connection c) {
        HourlyEmployeeDataAccess.initialize(c);
    }



    /**
     * Creating an instance method named displayToConsole()
     * that inherits from the super class and does not take any arguments, returns nothing and just
     * displays the returned string from the toString() method
     * using System.out.println(toString())
     */
    public void displayToConsole() {
        super.displayToConsole();
    }

    /**
     * toString() method so that the employee’s info is displayed.
     * For this method all attributes are retrieved by using
     * the getXxx() methods.
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        DecimalFormat decFrmt = new DecimalFormat("$15.00");
        s.append(super.toString());
        s.append("\tHourly rate: " + decFrmt.format(getHourly()) + "\n");
        s.append("\tDepartment: " + this.getDepartment() + "\n");
        return s.toString();
    }

    /**
     * @param anHourlyEmployee
     * @return boolean
     * @throws DuplicateEmployeeException
     */
    public boolean create(HourlyEmployee anHourlyEmployee) throws DuplicateEmployeeException {
        HourlyEmployeeDataAccess.create(anHourlyEmployee);
        return false;
    }

    /**
     * @param anHourlyEmployee
     * @return false
     */
    public boolean update(HourlyEmployee anHourlyEmployee) {
        HourlyEmployeeDataAccess.update(anHourlyEmployee);
        return false;
    }

    /**
     * @param anHourlyEmployee
     * @return false
     */
    public boolean delete(HourlyEmployee anHourlyEmployee) {
        HourlyEmployeeDataAccess.delete(anHourlyEmployee);
        return false;
    }

    /**
     * HourlyEmployee public method header for a method called getTypeForDisplay()
     * that takes no arguments and returns employee
     */
    public String getTypeForDisplay() {
        return "HourlyEmployee";
    }

}