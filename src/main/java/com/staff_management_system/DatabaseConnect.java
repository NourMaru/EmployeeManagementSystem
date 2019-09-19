package com.staff_management_system;

import java.sql.*;

public class DatabaseConnect {
    /**
     * Database location
     */
    static String url = "jdbc:postgresql://127.0.0.1:5432";
    /**
     * Connection object to open port to db
     */
    static Connection aConnection;
    /**
     * database user
     */
    static String user = "admin";
    /**
     * database user password
     */
    static String password = "password";

    /**
     * closes the database connection
     */
    public static void terminate() {
        try {
            aConnection.close();
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    /**
     * establishes the database connection
     *
     * @return Connection to the database
     */
    public Connection initialize() {
        try {
            Class.forName("org.postgresql.Driver"); // loads the JDBC Driver for PostGreSQL
            aConnection = DriverManager.getConnection(url, user, password); // creates the database connection instance

        } catch (ClassNotFoundException e)  //will occur if you did not import the PostGreSQL *.jar file with drivers
        {
            System.out.println(e);
        } catch (SQLException e)    //any other database exception (misnamed db, misnamed user, wrong password, etc)
        {
            System.out.println(e);
        }
        return aConnection;
    }
}

