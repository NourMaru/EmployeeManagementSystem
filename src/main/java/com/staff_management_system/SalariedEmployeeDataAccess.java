package com.staff_management_system;

import java.sql.*;

public class SalariedEmployeeDataAccess {

    /**
     * variables for all SalariedEmployee instance attribute values
     */
    long id;
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
    public SalariedEmployee retrieve(int id) throws NotFoundException, InvalidNameException, InvalidIdException { // retrieve employee data
        aSalariedEmployee = null;
        try {
            aStatement = aConnection.createStatement();
            // execute the SQL query statement
            ResultSet rs = aStatement.executeQuery("SELECT * FROM tblsalariedemployee WHERE id=" + id);

            // next method sets cursor & returns true if there is data

            if (rs.next()) { // extract the data
                aSalariedEmployee.setId(rs.getInt("id"));
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
                    aSalariedEmployee = new SalariedEmployee(id, firstName, lastName, role, startDate, sin, phoneNumber,
                            emailAddress, address, hourly, enabled, branch, education);
                } catch (InvalidEmployeeDataException e) {
                    System.out.println("Attempt to retrieve an HourlyEmployee that does exist (Id: " + id + ")\n" + "HourlyEmployee record with id " + id + "retrieved from the database");
                }

            } else // nothing was retrieved
            {
                throw (new NotFoundException("Attempt to retrieve a SalariedEmployee that does not exist (Id: " + id + ") \n" + "HourlyEmployee with if of " + id + " not found in the database."));
            }
            rs.close();
        } catch (SQLException e) {
            System.out.println(e);
        }

        return aSalariedEmployee;
    }


    /**
     * create new data in database
     *
     * @param aSalariedEmployee the new created data for employee
     * @return inserted when data inserted in database
     * @throws DuplicateEmployeeException
     */
    public boolean create(SalariedEmployee aSalariedEmployee) throws DuplicateEmployeeException {

        // retrieve the employee attribute values
        try {
            // create the SQL insert statement using attribute values
            PreparedStatement ps = aConnection.prepareStatement("INSERT INTO tblhourlyemployee VALUES (NULL, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)");

            ps.setLong(1, aSalariedEmployee.getId());
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
            int i = aStatement.executeUpdate("DELETE FROM tblsalariedemployee WHERE id=" + id);
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
     * @param aSalariedEmployee the update method for employee in database
     * @return records in the database
     */
    public final boolean update(SalariedEmployee aSalariedEmployee) {

        try {
            PreparedStatement ps = aConnection.prepareStatement("UPDATE tblhourlyemployee SET firstname=?, lastname=?, role=?, startdate=?, sin=?, phonenumber=?, emailaddress=?, address=?, hourly=?, enabled=?, branch=?, education=? WHERE id=?");


            ps.setString(1, aSalariedEmployee.getFirstName());
            ps.setString(2, aSalariedEmployee.getLastName());
            ps.setString(3, aSalariedEmployee.getRole());
            ps.setDate(4, (Date) aSalariedEmployee.getStartDate());
            ps.setString(5, aSalariedEmployee.getSin());
            ps.setLong(6, aSalariedEmployee.getPhoneNumber());
            ps.setString(7, aSalariedEmployee.getEmailAddress());
            ps.setString(8, aSalariedEmployee.getAddress());
            ps.setFloat(9, aSalariedEmployee.getHourly());
            ps.setBoolean(10, aSalariedEmployee.isEnabled());
            ps.setString(11, aSalariedEmployee.getBranch());
            ps.setString(12, aSalariedEmployee.getEducation());
        } catch (SQLException e) {
            System.out.println(e);
        }
        return false;
    }
}
