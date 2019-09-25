package com.database_connection;

import com.exceptions.*;
import com.staff.SalariedEmployee;

import java.sql.*;

public class SalariedEmployeeDataAccess {

    /**
     * variables for all SalariedEmployee instance attribute values
     */
    long id;
    String password;
    String firstName;
    String lastName;
    String role;
    Date startDate;
    String sin;
    long phoneNumber;
    String emailAddress;
    String address;
    float hourly;
    boolean enabled;
    String branch;
    String education;
    /**
     * variables for the database connection
     */
    private SalariedEmployee aSalariedEmployee;
    private Connection aConnection;
    private Statement aStatement;

    /**
     * @param c establish the database connection
     */

    public void initialize(Connection c) {
        try {
            aConnection = c;
            aStatement = aConnection.createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * close the database connection
     */
    public void terminate() {
        try {
            aStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * retrieve a salaried employee data from the database
     *
     * @param id the id for employee
     * @return anHourlyEmployee
     * @throws NotFoundException, NotFoundException, InvalidNameException, InvalidIdException, InvalidPasswordException
     */
    public SalariedEmployee retrieve(int id) throws NotFoundException, InvalidNameException, InvalidIdException, InvalidPasswordException { // retrieve employee data
        aSalariedEmployee = null;

        String sqlQuery = "SELECT id, firstname, lastname, role, startdate, sin, phonenumber, emailaddress, address, salary, enabled, branch, education FROM tblhourlyemployee WHERE id = '" + id + "'";

        try {
            aStatement = aConnection.createStatement();
            // execute the SQL query statement
            ResultSet rs = aStatement.executeQuery(sqlQuery);

            // next method sets cursor & returns true if there is data
            boolean retrievedData = rs.next();
            if (retrievedData) { // extract the data
                aSalariedEmployee.setId(rs.getInt("id"));
                aSalariedEmployee.setPassword(rs.getString("password1"));
                aSalariedEmployee.setFirstName(rs.getString("firstname"));
                aSalariedEmployee.setLastName(rs.getString("lastname"));
                aSalariedEmployee.setRole(rs.getString("role"));
                aSalariedEmployee.setStartDate(rs.getDate("startdate"));
                aSalariedEmployee.setSin(rs.getString("sin"));
                aSalariedEmployee.setPhoneNumber(rs.getLong("phonenumber"));
                aSalariedEmployee.setEmailAddress(rs.getString("emailaddress"));
                aSalariedEmployee.setAddress(rs.getString("address"));
                aSalariedEmployee.setHourly(rs.getFloat("hourly"));
                aSalariedEmployee.setEnabled(rs.getBoolean("enabled"));
                aSalariedEmployee.setBranch(rs.getString("branch"));
                aSalariedEmployee.setEducation(rs.getString("education"));


                try {
                    aSalariedEmployee = new SalariedEmployee(id, password, firstName, lastName, role, startDate, sin, phoneNumber,
                            emailAddress, address, hourly, enabled, branch, education);
                } catch (InvalidEmployeeDataException e) {
                    System.out.println("Attempt to retrieve an HourlyEmployee that does exist (Id: " + id + ")\n" + "HourlyEmployee record with id " + id + "retrieved from the database");
                }

            } else if (aSalariedEmployee.retrieve(id) == null)// nothing was retrieved
            {
                System.out.println("Attempt to retrieve a SalariedEmployee that does not exist (Id: " + id + ") \n" + "HourlyEmployee with if of " + id + " not found in the database.");
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aSalariedEmployee;
    }


    /**
     * create a new employee data in database
     *
     * @param aSalariedEmployee the new created data for employee
     * @return inserted when data inserted in database
     * @throws DuplicateEmployeeException this exception is thrown when there are duplicate of an employee data
     */
    public boolean create(SalariedEmployee aSalariedEmployee) throws DuplicateEmployeeException {

        // retrieve the employee attribute values
        try {
            // create the SQL insert statement using attribute values
            PreparedStatement ps = aConnection.prepareStatement("INSERT INTO tblhourlyemployee VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setLong(1, aSalariedEmployee.getId());
            ps.setString(2, aSalariedEmployee.getPassword());
            ps.setString(3, aSalariedEmployee.getFirstName());
            ps.setString(4, aSalariedEmployee.getLastName());
            ps.setString(5, aSalariedEmployee.getRole());
            ps.setDate(6, (Date) aSalariedEmployee.getStartDate());
            ps.setString(7, aSalariedEmployee.getSin());
            ps.setLong(8, aSalariedEmployee.getPhoneNumber());
            ps.setString(9, aSalariedEmployee.getEmailAddress());
            ps.setString(10, aSalariedEmployee.getAddress());
            ps.setFloat(11, aSalariedEmployee.getHourly());
            ps.setBoolean(12, aSalariedEmployee.isEnabled());
            ps.setString(13, aSalariedEmployee.getBranch());
            ps.setString(14, aSalariedEmployee.getEducation());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
            throw (new DuplicateEmployeeException("Problem with creating HourlyEmployee record, ID " + id + " already exists in the system."));

        } catch (SQLException ee) {
            ee.printStackTrace();
        }
        return false;
    }


    /**
     * delete employee data in the database
     *
     * @return records from database
     */
    public boolean delete(int id) {

        // see if this employee already exists in the database
        try {
            Statement aStatement = aConnection.createStatement();
            int i = aStatement.executeUpdate("DELETE FROM tblsalariedemployee WHERE id=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * update employee data in the database
     *
     * @param aSalariedEmployee the update method for employee in database
     * @return records in the database
     */
    public final boolean update(SalariedEmployee aSalariedEmployee) {

        try {
            PreparedStatement ps = aConnection.prepareStatement("UPDATE tblhourlyemployee SET password=?, firstname=?, lastname=?, role=?, startdate=?, sin=?, phonenumber=?, emailaddress=?, address=?, hourly=?, enabled=?, branch=?, education=? WHERE id=?");

            ps.setString(1, aSalariedEmployee.getPassword());
            ps.setString(2, aSalariedEmployee.getFirstName());
            ps.setString(3, aSalariedEmployee.getLastName());
            ps.setString(4, aSalariedEmployee.getRole());
            ps.setDate(5, (Date) aSalariedEmployee.getStartDate());
            ps.setString(6, aSalariedEmployee.getSin());
            ps.setLong(7, aSalariedEmployee.getPhoneNumber());
            ps.setString(8, aSalariedEmployee.getEmailAddress());
            ps.setString(9, aSalariedEmployee.getAddress());
            ps.setFloat(10, aSalariedEmployee.getHourly());
            ps.setBoolean(11, aSalariedEmployee.isEnabled());
            ps.setString(12, aSalariedEmployee.getBranch());
            ps.setString(13, aSalariedEmployee.getEducation());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * User login into the database
     *
     * @return anHourlyEmployee
     */
    public SalariedEmployee login(int id, String password) throws NotFoundException, InvalidEmployeeDataException { // retrieve hourly employee data
        aSalariedEmployee = null;
        // define the SQL query statement
        String sqlQuery = "SELECT id, password, firstname, lastname, role, startdate, sin, phonenumber, emailaddress, address, hourly, enabled, department FROM tblhourlyemployee WHERE id = '" + id + "' AND password = '" + password + "'";
        System.out.println(sqlQuery);
        // execute the SQL query statement
        try {
            ResultSet rs = aStatement.executeQuery(sqlQuery);
            // next method sets cursor & returns true if there is data
            boolean gotIt = rs.next();
            if (gotIt) { // extract the data
                id = rs.getInt("id");
                password = rs.getString("password");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                role = rs.getString("role");
                startDate = rs.getDate("startdate");
                sin = rs.getString("sin");
                phoneNumber = rs.getLong("phonenumber");
                emailAddress = rs.getString("emailaddress");
                address = rs.getString("address");
                hourly = rs.getFloat("hourly");
                enabled = rs.getBoolean("enabled");
                branch = rs.getString("branch");
                education = rs.getString("education");


                aSalariedEmployee = new SalariedEmployee(id, password, firstName, lastName, role, startDate, sin, phoneNumber, emailAddress, address, hourly, enabled, branch, education);

            } else // nothing was retrieved
            {
                throw (new NotFoundException("Attempt to retrieve an HourlyEmployee that does not exist (Id: " + id + ") \n" + "Employee with if of " + id + " not found in the database."));
            }
            rs.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aSalariedEmployee;
    }


    /**
     * check if employee does exist in the database
     *
     * @return exists
     */
    public boolean isExistingLogin(String id) {
        // retrieve employee data
        // define the SQL query statement using the id key
        String sqlQuery = "SELECT id, password, firstname, lastname, role, startdate, sin, phonenumber, emailaddress, address, hourly, enabled, department FROM tblhourlyemployee WHERE id = " + id;
        //System.out.println(sqlQuery);
        boolean exists = true;
        // execute the SQL query statement
        try {
            aStatement = aConnection.createStatement();
            ResultSet rs = aStatement.executeQuery(sqlQuery);
            exists = rs.next();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return exists;
    }
}
