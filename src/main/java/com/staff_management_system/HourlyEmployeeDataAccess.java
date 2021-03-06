package com.staff_management_system;

import java.sql.*;

/**
 * Subclass HourlyEmployeeDataAccess that holds default and parameterized constructors with values.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */
public class HourlyEmployeeDataAccess {

    /**
     * variables for the database connection
     */
    public HourlyEmployee anHourlyEmployee;
    /**
     * variables for all HourlyEmployee instance attribute values
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
    String department;
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
            System.out.println(e);
        }
    }

    /**
     * close the database connection
     */
    public void terminate() {
        try {
            aStatement.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }


    /**
     * retrieve the database connection
     *
     * @param id the id for employee
     * @return anHourlyEmployee
     * @throws NotFoundException
     */
    public HourlyEmployee retrieve(int id) throws NotFoundException, InvalidNameException, InvalidIdException, InvalidPasswordException { // retrieve employee data
        anHourlyEmployee = null;
        try {
            aStatement = aConnection.createStatement();
            // execute the SQL query statement
            ResultSet rs = aStatement.executeQuery("SELECT * FROM tblhourlyemployee WHERE id=" + id);

            // next method sets cursor & returns true if there is data

            if (rs.next()) { // extract the data
                anHourlyEmployee.setId(rs.getInt("id"));
                anHourlyEmployee.setPassword(rs.getString("password"));
                anHourlyEmployee.setFirstName(rs.getString("firstname"));
                anHourlyEmployee.setLastName(rs.getString("lastname"));
                anHourlyEmployee.setRole(rs.getString("role"));
                anHourlyEmployee.setStartDate(rs.getDate("startdate"));
                anHourlyEmployee.setSin(rs.getString("sin"));
                anHourlyEmployee.setPhoneNumber(rs.getLong("phonenumber"));
                anHourlyEmployee.setEmailAddress(rs.getString("emailaddress"));
                anHourlyEmployee.setAddress(rs.getString("address"));
                anHourlyEmployee.setHourly(rs.getFloat("hourly"));
                anHourlyEmployee.setEnabled(rs.getBoolean("enabled"));
                anHourlyEmployee.setDepartment(rs.getString("department"));


                try {
                    anHourlyEmployee = new HourlyEmployee(id, password, firstName, lastName, role, startDate, sin, phoneNumber,
                            emailAddress, address, hourly, enabled, department);
                } catch (InvalidEmployeeDataException e) {
                    System.out.println("Attempt to retrieve an HourlyEmployee that does exist (Id: " + id + ")\n" + "HourlyEmployee record with id " + id + "retrieved from the database");
                }

            } else // nothing was retrieved
            {
                throw (new NotFoundException("Attempt to retrieve an HourlyEmployee that does not exist (Id: " + id + ") \n" + "HourlyEmployee with if of " + id + " not found in the database."));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return anHourlyEmployee;
    }


    /**
     * create new data in database
     *
     * @param anHourlyEmployee the new created data for employee
     * @return inserted when data inserted in database
     * @throws DuplicateEmployeeException
     */
    public boolean create(HourlyEmployee anHourlyEmployee) throws DuplicateEmployeeException {

        // retrieve the employee attribute values
        try {
            // create the SQL insert statement using attribute values
            PreparedStatement ps = aConnection.prepareStatement("INSERT INTO tblhourlyemployee VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");

            ps.setLong(1, anHourlyEmployee.getId());
            ps.setString(2, anHourlyEmployee.getPassword());
            ps.setString(3, anHourlyEmployee.getFirstName());
            ps.setString(4, anHourlyEmployee.getLastName());
            ps.setString(5, anHourlyEmployee.getRole());
            ps.setDate(6, (Date) anHourlyEmployee.getStartDate());
            ps.setString(7, anHourlyEmployee.getSin());
            ps.setLong(8, anHourlyEmployee.getPhoneNumber());
            ps.setString(9, anHourlyEmployee.getEmailAddress());
            ps.setString(10, anHourlyEmployee.getAddress());
            ps.setFloat(11, anHourlyEmployee.getHourly());
            ps.setBoolean(12, anHourlyEmployee.isEnabled());
            ps.setString(13, anHourlyEmployee.getDepartment());

            int i = ps.executeUpdate();
            if (i == 1) {
                return true;
            }
            throw (new DuplicateEmployeeException("Problem with creating HourlyEmployee record, ID " + id + " already exists in the system."));

        } catch (SQLException ee) {
            System.out.println(ee);
        }
        return false;
    }


    /**
     * delete data in the database
     * the deleted method for employee
     *
     * @return records from database
     */
    public boolean delete(int id) {

        // see if this employee already exists in the database
        try {
            Statement aStatement = aConnection.createStatement();
            int i = aStatement.executeUpdate("DELETE FROM tblhorlyemployee WHERE id=" + id);
            if (i == 1) {
                return true;
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    /**
     * update data in the database
     *
     * @param anHourlyEmployee the update method for employee in database
     * @return records in the database
     */
    public final boolean update(HourlyEmployee anHourlyEmployee) {

        try {
            PreparedStatement ps = aConnection.prepareStatement("UPDATE tblhourlyemployee SET passwprd=?, firstname=?, lastname=?, role=?, startdate=?, sin=?, phonenumber=?, emailaddress=?, address=?, hourly=?, enabled=?, department=? WHERE id=?");

            ps.setString(1, anHourlyEmployee.getPassword());
            ps.setString(2, anHourlyEmployee.getFirstName());
            ps.setString(3, anHourlyEmployee.getLastName());
            ps.setString(4, anHourlyEmployee.getRole());
            ps.setDate(5, (Date) anHourlyEmployee.getStartDate());
            ps.setString(6, anHourlyEmployee.getSin());
            ps.setLong(7, anHourlyEmployee.getPhoneNumber());
            ps.setString(8, anHourlyEmployee.getEmailAddress());
            ps.setString(9, anHourlyEmployee.getAddress());
            ps.setFloat(10, anHourlyEmployee.getHourly());
            ps.setBoolean(11, anHourlyEmployee.isEnabled());
            ps.setString(12, anHourlyEmployee.getDepartment());
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }

    public HourlyEmployee login(int id, String password) throws NotFoundException, InvalidEmployeeDataException { // retrieve hourly employee data
        anHourlyEmployee = null;
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
                department = rs.getString("department");


                anHourlyEmployee = new HourlyEmployee(id, password, firstName, lastName, role, startDate, sin, phoneNumber, emailAddress, address, hourly, enabled, department);

            } else // nothing was retrieved
            {
                throw (new NotFoundException("Attempt to retrieve an HourlyEmployee that does not exist (Id: " + id + ") \n" + "Employee with if of " + id + " not found in the database."));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return anHourlyEmployee;
    }


    public boolean isExistingLogin(String id) {
        // retrieve employee data
        // define the SQL query statement using the id key
        String sqlQuery = "SELECT  * FROM students WHERE id= '" + id + "'";
        //System.out.println(sqlQuery);
        boolean exists = true;
        // execute the SQL query statement
        try {
            aStatement = aConnection.createStatement();
            ResultSet rs = aStatement.executeQuery(sqlQuery);
            exists = rs.next();
        } catch (SQLException e) {
            System.out.println(e);
        }
        return exists;
    }
}