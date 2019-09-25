package com.main_class;

import com.exceptions.*;
import com.user_interface.UserInterface;

import javax.mail.internet.InternetAddress;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;


/**
 * Class User that holds default and parameterized constructors with values.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */

public class User implements UserInterface {

    //The default minimum length for password shared variable
    private final static int MINIMUM_PASSWORD_LENGTH = 6;
    //The default maximum length for password shared variable
    private final static int MAXIMUM_PASSWORD_LENGTH = 12;
    //The default date format shared variable
    private final DateFormat DF = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.CANADA);

    //The id instance variable
    private int id;
    //The password instance variable
    private String password;
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
    private float salary;
    //The employee's hourly wage instance variable
    private float hourly;
    //The enabled instance variable
    private boolean enabled;

    /**
     * @return method header for a method called getTypeForDisplay() that takes no arguments
     * and returns a String.
     */
    String getTypeForDisplay() {
        return null;
    }

    /**
     * @return public abstract method named isValidEmailAddress() that takes string arguments and returns a boolean.
     */
    @Override
    public boolean isValidEmailAddress(String email) {
        boolean result = true;
        try {
            InternetAddress emailAddress = new InternetAddress(email);
            emailAddress.validate();
        } catch (Exception ex) {
            return false;
        }
        return true;
    }

    /**
     * return the id attribute for the employee
     *
     * @return the id
     */
    @Override
    public int getId() {
        return id;
    }

    /**
     * Set the id attribute for the employee
     *
     * @param id the id to set
     * @throws InvalidIdException this exception is thrown if the id is invalid
     */
    @Override
    public void setId(int id)
            throws InvalidIdException {
        if (verifyId(id)) {
            this.id = id;
        } else {
            throw new InvalidIdException("\n" + id + " is not a valid employee id.");
        }
    }

    /**
     * return the password attribute for the User
     *
     * @return the password
     */
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Set the password attribute for the User
     *
     * @param password the password to set
     * @throws InvalidPasswordException this exception is thrown if the password is smaller or bigger than the character limit
     */
    @Override
    public void setPassword(String password) throws InvalidPasswordException {

        if (password.length() > MINIMUM_PASSWORD_LENGTH && password.length() < MAXIMUM_PASSWORD_LENGTH)
            this.password = password;
        else
            throw new InvalidPasswordException("\nThe user password must be between " + MINIMUM_PASSWORD_LENGTH + " and " + MAXIMUM_PASSWORD_LENGTH + " characters long.");
    }

    /**
     * return the first name attribute for the employee
     *
     * @return the firstName
     */
    @Override
    public String getFirstName() {
        return firstName;
    }

    /**
     * Set the first name attribute for the employee
     *
     * @param firstName the firstName to set
     * @throws InvalidNameException this exception is thrown if the first name is invalid
     */
    @Override
    public void setFirstName(String firstName) throws InvalidNameException {
        if (!Objects.equals(firstName, ""))
            this.firstName = firstName;
        else {
            throw new InvalidNameException("\nYou must provide a first name");
        }
    }

    /**
     * return the last name attribute for the employee
     *
     * @return the lastName
     */
    @Override
    public String getLastName() {
        return lastName;
    }

    /**
     * Set the last name attribute for the employee
     *
     * @param lastName the lastName to set
     * @throws InvalidNameException this exception is thrown if the last name is invalid
     */
    @Override
    public void setLastName(String lastName) throws InvalidNameException {
        if (!Objects.equals(lastName, ""))
            this.lastName = lastName;
        else {
            throw new InvalidNameException("\nYou must provide a last name");
        }
    }

    /**
     * return the role attribute for the employee
     *
     * @return the role
     */
    @Override
    public String getRole() {
        return role;
    }

    /**
     * Set the role attribute for the employee
     *
     * @param role the role to set
     */
    @Override
    public void setRole(String role) {
        this.role = role;
    }

    /**
     * return the start date attribute for the employee
     *
     * @return the startDate
     */
    @Override
    public Date getStartDate() {
        return startDate;
    }

    /**
     * Set the start date attribute for the employee
     *
     * @param startDate the startDate to set
     */
    @Override
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * return the social insurance number attribute for the employee
     *
     * @return the sin
     */
    @Override
    public String getSin() {
        return sin;
    }

    /**
     * Set the social insurance number attribute for the employee
     *
     * @param sin the sin to set
     */
    @Override
    public void setSin(String sin) {
        this.sin = sin;
    }

    /**
     * return the phone number attribute for the employee
     *
     * @return the phoneNumber
     */
    @Override
    public long getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Set the phone number attribute for the employee
     *
     * @param phoneNumber the phoneNumber to set
     */
    @Override
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * return the email address attribute for the employee
     *
     * @return the emailAddress
     */
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }

    /**
     * Set the email address attribute for the employee
     *
     * @param emailAddress the emailAddress to set
     */
    @Override
    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     * return the address attribute for the employee
     *
     * @return the address
     */
    @Override
    public String getAddress() {
        return address;
    }

    /**
     * Set the address attribute for the employee
     *
     * @param address the address to set
     */
    @Override
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * return the salary attribute for the employee
     *
     * @return the salary
     */
    public float getSalary() {
        return salary;
    }

    /**
     * Set the salary attribute for the employee
     *
     * @param salary the salary to set
     */
    public void setSalary(float salary) {
        this.salary = salary;
    }

    /**
     * return the Hourly attribute for the employee
     *
     * @return the hourly
     */
    @Override
    public float getHourly() {
        return hourly;
    }

    /**
     * Set the Hourly attribute for the employee
     *
     * @param hourly the hourly to set
     */
    @Override
    public void setHourly(float hourly) {
        this.hourly = hourly;
    }

    /**
     * return the enabled attribute for the employee
     *
     * @return the enabled
     */
    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * Set the enables attribute for the employee
     *
     * @param enabled the enabled to set
     */
    @Override
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    /**
     * A non static instance method that overloads the java.Object’s
     * toString() creates a specific employee’s information as a String
     */
    public String toString() {
        StringBuilder s = new StringBuilder();

        s.append("HourlyEmployee Info for: ").append(this.getId()).append("\n");
        s.append("\tName: ").append(this.getFirstName()).append(" ").append(this.getLastName()).append("\n");
        s.append("\tRole: ").append(this.getRole()).append("\n");
        s.append("\tStarted on: ").append(DF.format(this.getStartDate())).append("\n");
        s.append("\tS.I.N: ").append(this.getSin()).append("\n");
        s.append("\tPhone Number: ").append(String.valueOf(phoneNumber).replaceFirst("(\\d{3})(\\d{3})(\\d+)", "($1)$2-$3")).append("\n");
        s.append("\tEmail Address: ").append(this.getEmailAddress()).append("\n");
        s.append("\tAddress: ").append(this.getAddress()).append("\n");
        s.append("\tEnabled: ").append(this.isEnabled()).append("\n");
        return s.toString();
    }

    /**
     * an instance method named displayToConsole()
     * that does not take any arguments, returns nothing and just
     * displays the returned string from the toString() method
     * using System.out.println(toString())
     */
    @Override
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
    private boolean verifyId(long id) {

        boolean isValid;
        isValid = false;
        int idConverted = String.valueOf(id).length();

        //The default number length of employee's ID shared variable
        byte ID_NUMBER_LENGTH = 6;
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
    @Override
    public boolean create() throws DuplicateEmployeeException {
        return false;
    }

    /**
     * @return public abstract method named update() that takes no arguments and returns an int.
     */
    @Override
    public int update() throws NotFoundException {
        return 0;
    }

    /**
     * @return public abstract method named delete() that takes no arguments and returns an int.
     */
    @Override
    public int delete() throws NotFoundException {
        return 0;
    }
}
