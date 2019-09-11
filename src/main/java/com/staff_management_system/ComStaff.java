package com.staff_management_system;

import javax.mail.internet.InternetAddress;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;


/**
 * Class ComStaff that holds default and parameterized constructors with values.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */

public class ComStaff {

    //The id instance variable
    private int id;

    //The employee's first name instance variable
    private String firstName;

    //The employee's last name instance variable
    private String lastName;

    //The role at company instance variable
    private String role;

    //The employee's start working at company date instance variable
    private Date startDate;

    //The employee's social insurance number instance variable
    private String sin;

    //The employee's personal phone number instance variable
    private long phoneNumber;

    //The employee's email address instance variable
    private String emailAddress;

    //The employee's home address instance variable
    private String address;

    //The employee's salary instance variable
    private double salary;

    //The employee's hourly wage instance variable
    private double hourly;

    //The enabled instance variable
    private boolean enabled;

    //The default date format shared variable
    public final static DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

    //The default number length of employee's ID shared variable
    public final static byte ID_NUMBER_LENGTH = 6;


    /**
     * return the id attribute for the employee
     *
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * Set the id attribute for the employee
     *
     * @param id the id to set
     * @throws InvalidIdException this exception is thrown if the id is invalid
     */
    public void setId(int id)
            throws InvalidIdException {
        if (verifyId(id)) {
            this.id = id;
        } else {
            throw new InvalidIdException("\n" + id + " is not a valid employee id.");
        }
    }

    /**
     * return the first name attribute for the employee
     *
     * @return the firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name attribute for the employee
     *
     * @param firstName the firstName to set
     * @throws InvalidNameException this exception is thrown if the first name is invalid
     */
    public void setFirstName(String firstName) throws InvalidNameException {
        if (firstName != new String(""))
            this.firstName = firstName;
        else
            throw new InvalidNameException("\nYou must provide a first name");
    }

    /**
     * return the last name attribute for the employee
     *
     * @return the lastName
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name attribute for the employee
     *
     * @param lastName the lastName to set
     * @throws InvalidNameException this exception is thrown if the last name is invalid
     */
    public void setLastName(String lastName) throws InvalidNameException {
        if (lastName != "")
            this.lastName = lastName;
        else
            throw new InvalidNameException("\nYou must provide a last name");
    }

    /**
     * return the role attribute for the employee
     *
     * @return the role
     */
    public String getRole() {
        return role;
    }

    /**
     * Set the role attribute for the employee
     *
     * @param role the role to set
     */
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * return the start date attribute for the employee
     *
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the start date attribute for the employee
     *
     * @param startDate the startDate to set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * return the social insurance number attribute for the employee
     *
     * @return the sin
     */
    public String getSin() {
        return sin;
    }

    /**
     * Set the social insurance number attribute for the employee
     *
     * @param sin the sin to set
     */
    public void setSin(String sin) {
        this.sin = sin;
    }

    /**
     * return the phone number attribute for the employee
     *
     * @return the phoneNumber
     */
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number attribute for the employee
     *
     * @param phoneNumber the phoneNumber to set
     */
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * return the email address attribute for the employee
     *
     * @return the emailAddress
     */
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the email address attribute for the employee
     *
     * @param emailAddress the emailAddress to set
     */
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * return the address attribute for the employee
     *
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * Set the address attribute for the employee
     *
     * @param address the address to set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * return the salary attribute for the employee
     *
     * @return the salary
     */
    public double getSalary() {
        return salary;
    }

    /**
     * Set the salary attribute for the employee
     *
     * @param salary the salary to set
     */
    public void setSalary(double salary) {
        this.salary = salary;
    }

    /**
     * return the Hourly attribute for the employee
     *
     * @return the hourly
     */
    public double getHourly() {
        return hourly;
    }

    /**
     * Set the Hourly attribute for the employee
     *
     * @param hourly the hourly to set
     */
    public void setHourly(double hourly) {
        this.hourly = hourly;
    }

    /**
     * return the enabled attribute for the employee
     *
     * @return the enabled
     */
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set the enables attribute for the employee
     *
     * @param enabled the enabled to set
     */
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }


    /**
     * A non static instance method that overloads the java.Object’s
     * toString() creates a specific employee’s information as a String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("HourlyEmployee Info for: " + this.getId() + "\n");
        s.append("\tName: " + this.getFirstName() + " " + this.getLastName() + "\n");
        s.append("\tRole: " + this.getRole() + "\n");
        s.append("\tStarted on: " + DF.format(this.getStartDate()) + "\n");
        s.append("\tS.I.N: " + this.getSin() + "\n");
        s.append("\tPhone Number: " + String.valueOf(phoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3") + "\n");
        s.append("\tEmail Address: " + this.getEmailAddress() + "\n");
        s.append("\tAddress: " + this.getAddress() + "\n");
        s.append("\tEnabled: " + this.isEnabled() + "\n");

        return s.toString();
    }

    /**
     * an instance method named displayToConsole()
     * that does not take any arguments, returns nothing and just
     * displays the returned string from the toString() method
     * using System.out.println(toString())
     */
    public void displayToConsole() {

        System.out.println(this.toString());
    }

    /**
     * Creating a class method named verifyId() that
     * accepts a int argument and checks, using ID_NUMBER_LENGTH,
     * whether the string passed is valid
     *
     * @param id - a class method named verifyId() that
     *           accepts a int argument and checks, using ID_NUMBER_LENGTH.
     *           It also checks if the entered ID is negative.
     * @return the string passed is valid
     */
    public boolean verifyId(int id) {

        boolean isValid = false;
        int idConverted = String.valueOf(id).length();

        if (idConverted == ID_NUMBER_LENGTH) {
            isValid = true;
        } else if (idConverted <= 0) {
            isValid = false;
        }
        return isValid;
    }

    /**
     * @return public abstract method named create() that takes no arguments and returns a boolean.
     */
    public boolean create() throws DuplicateEmployeeException {
        return false;
    }
    /**
     * @return public abstract method named update() that takes no arguments and returns an int.
     */
    public int update() throws NotFoundException {
        return 0;
    }
    /**
     * @return public abstract method named delete() that takes no arguments and returns an int.
     */
    public int delete() throws NotFoundException {
        return 0;
    }

   /**
    *  @return public abstract method named isValidEmailAddress() that takes string arguments and returns a boolean.
    */
    public static boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (Exception ex) {
            result = false;
        }
        return result;
    }
}
