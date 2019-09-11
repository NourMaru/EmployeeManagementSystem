package com.staff_management_system;

import java.sql.*;

/**
 * Subclass EmployeeDA that holds default and parameterized constructors with values.
 *
 * @author Nour Al Jarrah
 * @version 2.0
 * @since 1.0
 */
public class EmployeeDA {

    /**
     * variables for the database connection
     */
    static HourlyEmployee anHourlyEmployee;
    static Connection aConnection;
    static Statement aStatement;

    /**
     * static variables for all HourlyEmployee instance attribute values
     */
    static long id;
    static String firstName;
    static String lastName;
    static String role;
    static Date startDate;
    static String sin;
    static long phoneNumber;
    static String emailAddress;
    static String address;
    static double hourly;
    static boolean enabled;
    static String department;


    /**
     * @param c establish the database connection
     */

    public static void initialize(Connection c) {
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
    public static void terminate() {
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
    public static HourlyEmployee retrieve(int id) throws NotFoundException { // retrieve employee data
        anHourlyEmployee = null;
        // define the SQL query statement
        String sqlQuery = "SELECT id, firstname, lastname, emailaddress, role, startdate, sin, phonenumber, emailaddress, address, hourly, enabled, department" +
                " FROM employees " +
                " WHERE id = '" + id + "'";

        // execute the SQL query statement
        try {
            ResultSet rs = aStatement.executeQuery(sqlQuery);
            // next method sets cursor & returns true if there is data
            boolean gotIt = rs.next();
            if (gotIt) { // extract the data
                id = rs.getInt("id");
                firstName = rs.getString("firstname");
                lastName = rs.getString("lastname");
                role = rs.getString("role");
                startDate = rs.getDate("startdate");
                sin = rs.getString("sin");
                phoneNumber = rs.getLong("phonenumber");
                emailAddress = rs.getString("emailaddress");
                address = rs.getString("address");
                hourly = rs.getDouble("hourly");
                enabled = rs.getBoolean("enabled");
                department = rs.getString("department");


                try {
                    anHourlyEmployee = new HourlyEmployee(id, firstName, lastName, role, startDate, sin, phoneNumber,
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
    public static boolean create(HourlyEmployee anHourlyEmployee) throws DuplicateEmployeeException {
        boolean inserted = false; //insertion success flag
        // retrieve the employee attribute values
        id = anHourlyEmployee.getId();
        firstName = anHourlyEmployee.getFirstName();
        lastName = anHourlyEmployee.getLastName();
        role = anHourlyEmployee.getRole();
        startDate = (Date) anHourlyEmployee.getStartDate();
        sin = anHourlyEmployee.getSin();
        phoneNumber = anHourlyEmployee.getPhoneNumber();
        emailAddress = anHourlyEmployee.getEmailAddress();
        address = anHourlyEmployee.getAddress();
        hourly = anHourlyEmployee.getHourly();
        enabled = anHourlyEmployee.isEnabled();
        department = anHourlyEmployee.getDepartment();


        // create the SQL insert statement using attribute values
        String sqlInsert = "INSERT INTO employees " +
                "(id, firstName, lastName, role, startDate, sin, phoneNumber, emailAddress, address, hourly, enabled, department)" +

                "VALUES ('" + id + "', '" +

                firstName + "', '" +
                lastName + "', '" +
                role + "', '" +
                startDate + "', '" +
                sin + "', '" +
                phoneNumber + "', '" +
                emailAddress + "', '" +
                address + "', '" +
                hourly + "', '" +
                enabled + "', '" +
                department + "')";

        // see if this employee already exists in the database
        try {
            retrieve((int) id);
            throw (new DuplicateEmployeeException("Problem with creating HourlyEmployee record, ID " + id + " already exists in the system."));
        }
        // if NotFoundException, add employee to database
        catch (NotFoundException e) {
            try { // execute the SQL update statement
                inserted = aStatement.execute(sqlInsert);
            } catch (SQLException ee) {
                System.out.println(ee);
            }
        }
        return inserted;
    }

    /**
     * delete data in the database
     *
     * @param anHourlyEmployee the deleted method for employee
     * @return records from database
     * @throws NotFoundException
     */
    public static int delete(HourlyEmployee anHourlyEmployee) throws NotFoundException {
        int records = 0;
        id = anHourlyEmployee.getId();
        // create the SQL delete statement
        String sqlDelete = "DELETE FROM employees " +
                "WHERE id = '" + id + "'";

        // see if this employee already exists in the database
        try {
            EmployeeDA.retrieve((int) id); //used to determine if record exists for the passed employee
            // if found, execute the SQL update statement
            records = aStatement.executeUpdate(sqlDelete);
        } catch (NotFoundException e) {
            throw new NotFoundException("\nDid not find employee record with id " + 100222222);
        } catch (SQLException e) {
            System.out.println(e);
        }
        return records;
    }

    /**
     * update data in the database
     *
     * @param anHourlyEmployee the update method for employee in database
     * @return records in the database
     * @throws NotFoundException
     */
    public static int update(HourlyEmployee anHourlyEmployee) throws NotFoundException {
        int records = 0; //records updated in method

        // retrieve the student argument attribute values
        id = anHourlyEmployee.getId();
        firstName = anHourlyEmployee.getFirstName();
        lastName = anHourlyEmployee.getLastName();
        role = anHourlyEmployee.getRole();
        startDate = (Date) anHourlyEmployee.getStartDate();
        sin = anHourlyEmployee.getSin();
        phoneNumber = anHourlyEmployee.getPhoneNumber();
        emailAddress = anHourlyEmployee.getEmailAddress();
        address = anHourlyEmployee.getAddress();
        hourly = anHourlyEmployee.getHourly();
        enabled = anHourlyEmployee.isEnabled();
        department = anHourlyEmployee.getDepartment();

        // define the SQL query statement using the id
        String sqlUpdate = "UPDATE employees " +

                " SET firstname = '" + firstName + "' " +
                " lastname = '" + lastName + "' " +
                " role = '" + role + "'" +
                " startdate = '" + startDate + "'" +
                " sin = '" + sin + "'" +
                " phonenumber = '" + phoneNumber + "'" +
                " emailaddress = '" + emailAddress + "' " +
                " address = '" + address + "'" +
                " hourly = '" + hourly + "'" +
                " enabled = '" + enabled + "' " +
                " department = '" + department + "'" +
                " WHERE id = '" + id + "'";

        try {
            HourlyEmployee.retrieve((int) id); //determine if there is an employee record to be updated
            // if found, execute the SQL update statement
            records = aStatement.executeUpdate(sqlUpdate);
        } catch (NotFoundException e) {
            throw new NotFoundException("Change the employee object and attempt to update " + "the employee record for " + firstName + lastName + "(Id: " + id + ")employee record updated in the database.");
        } catch (SQLException e) {
            System.out.println(e);
        }
        return records;
    }


}
