package com.user_interface;

import com.exceptions.*;

import java.util.Date;

public interface UserInterface {
    /**
     * The default company name shared variable
     */
    String COMPANY_NAME = "=== COMPANY ===";
    /**
     * The default phone number shared variable
     */
    long PHONE_NUMBER = 6475294336L;
    /**
     * The default minimum id number shared variable
     */
    int MINIMUM_ID_NUMBER = 100000;
    /**
     * The default maximum id number shared variable
     */
    int MAXIMUM_ID_NUMBER = 999999;

    boolean isValidEmailAddress(String email);

    int getId();

    void setId(int id)
            throws InvalidIdException;

    String getPassword();

    void setPassword(String password) throws InvalidPasswordException;

    String getFirstName();

    void setFirstName(String firstName) throws InvalidNameException;

    String getLastName();

    void setLastName(String lastName) throws InvalidNameException;

    String getRole();

    void setRole(String role);

    Date getStartDate();

    void setStartDate(Date startDate);

    String getSin();

    void setSin(String sin);

    long getPhoneNumber();

    void setPhoneNumber(long phoneNumber);

    String getEmailAddress();

    void setEmailAddress(String emailAddress);

    String getAddress();

    void setAddress(String address);

    float getHourly();

    void setHourly(float hourly);

    boolean isEnabled();

    void setEnabled(boolean enabled);

    String toString();

    void displayToConsole();

    boolean create() throws DuplicateEmployeeException;

    int update() throws NotFoundException;

    int delete() throws NotFoundException;
}
