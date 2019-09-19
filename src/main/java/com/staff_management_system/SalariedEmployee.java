package com.staff_management_system;

import java.sql.Connection;
import java.text.DecimalFormat;
import java.util.Date;

/**
 * Subclass SalariedEmployee that holds default and parameterized constructors with values.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */
public class SalariedEmployee extends User {

    /**
     * instance attributes that will be used with attributes of the ComStaff class
     */
    //The branch instance variable
    private String branch;

    //The education instance variable
    private String education;

    /**
     * return the branch attribute for the SalariedEmployee
     *
     * @return the branch
     */
    public String getBranch() {
        return branch;
    }

    /**
     * set the branch attribute for the SalariedEmployee
     *
     * @param branch the branch to set
     */
    public void setBranch(String branch) {
        this.branch = branch;
    }

    /**
     * return the education attribute for the SalariedEmployee
     *
     * @return the education
     */
    public String getEducation() {
        return education;
    }

    /**
     * set the education attribute for the SalariedEmployee
     *
     * @param education the education to set
     */
    public void setEducation(String education) {
        this.education = education;
    }


    /**
     * A parameterized constructor that accepts arguments for
     * the types corresponding to the listed attributes,
     * and places each argument into its appropriate
     * attribute using the setXxx() method
     *
     * @param id           the id for manager
     * @param firstName    the first name for manager
     * @param lastName     the last name for manager
     * @param role         the role for manager
     * @param startDate    the start date for manager
     * @param sin          the social insurance number for manager
     * @param phoneNumber  the phone number for manager
     * @param emailAddress the email address for manager
     * @param address      the address for manager
     * @param salary       the salary for manager
     * @param isEnabled    the enabled for manager
     * @param branch       the branch for manager
     * @param education    the education for manager
     * @throws InvalidEmployeeDataException this exception is thrown if the manager's data is invalid
     */
    public SalariedEmployee(int id, String firstName, String lastName, String role,
                            Date startDate, String sin, long phoneNumber, String emailAddress,
                            String address, float salary, boolean isEnabled, String branch, String education)
            throws InvalidEmployeeDataException {
        try {
            this.setId(id);
            this.setFirstName(firstName);
            this.setLastName(lastName);
            this.setRole(role);
            this.setStartDate(startDate);
            this.setSin(sin);
            this.setPhoneNumber(phoneNumber);
            this.setEmailAddress(emailAddress);
            this.setAddress(address);
            this.setSalary(salary);
            this.setEnabled(isEnabled);
            this.setBranch(branch);
            this.setEducation(education);
        } catch (Exception e) {
            throw new InvalidEmployeeDataException(e.getMessage());
        }
    }


    /**
     * A non static instance method that overloads the java.Object’s
     * toString() creates a specific employees’s information as a String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();
        DecimalFormat decFrmt = new DecimalFormat("$0,000.00");
        s.append(super.toString());
        s.append("\tSalary: " + decFrmt.format(getSalary()) + "\n");
        s.append("\tBranch: " + this.getBranch() + "\n");
        s.append("\tEducation: " + this.getEducation() + "\n");
        return s.toString();
    }

    /**
     * @param id the employee's Id
     * @throws NotFoundException exception is thrown if the employee record not found
     */
    public SalariedEmployee retrieve(int id) throws NotFoundException {
        return SalariedEmployeeDataAccess.retrieve(id);
    }

    /**
     * HourlyEmployee public method header for a method called terminate()
     * that takes no arguments and calls employee
     */
    public void terminate() {
        SalariedEmployeeDataAccess.terminate();
    }

    /**
     * @param id
     * @return the employee's record as an instance of employee
     * @throws NotFoundException
     */
    public SalariedEmployee find(int id) throws NotFoundException {
        return SalariedEmployeeDataAccess.retrieve(id);
    }

    /**
     * initialize()
     * employee public method header for a method called initialize()
     * that takes connection arguments and calls employee
     */

    public void initialize(Connection c) {
        SalariedEmployeeDataAccess.initialize(c);
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
     * @param aSalariedEmployee
     * @return boolean
     * @throws DuplicateEmployeeException
     */
    public boolean create(SalariedEmployee aSalariedEmployee) throws DuplicateEmployeeException {
        SalariedEmployeeDataAccess.create(aSalariedEmployee);
        return false;
    }

    /**
     * @param aSalariedEmployee
     * @return false
     */
    public boolean update(SalariedEmployee aSalariedEmployee) {
        SalariedEmployeeDataAccess.update(aSalariedEmployee);
        return false;
    }

    /**
     * @param aSalariedEmployee
     * @return false
     */
    public boolean delete(SalariedEmployee aSalariedEmployee) {
        SalariedEmployeeDataAccess.delete(aSalariedEmployee);
        return false;
    }


    /*
     * SalariedEmployee public method header for a method called getTypeForDisplay()
     * that takes no arguments and returns SalariedEmployee
     */
    public String getTypeForDisplay() {
        return "SalariedEmployee";
    }
}