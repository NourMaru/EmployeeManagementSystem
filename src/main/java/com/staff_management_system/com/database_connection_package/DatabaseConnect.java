package com.database_connection_package;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnect {
    /**
     * Connection object to open port to db
     */
    private final ThreadLocal<Connection> aConnection = new ThreadLocal<>();

    /**
     * closes the database connection
     */
    public void terminate() {
        try {
            aConnection.get().close();
        } catch (SQLException e) {
            e.printStackTrace();
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

            //Database location
            String url = "jdbc:postgresql://127.0.0.1:5432";

            //database user
            String user = "admin";

            //database user password
            String password = "password";

            aConnection.set(DriverManager.getConnection(url, user, password)); // creates the database connection instance

        } catch (ClassNotFoundException | SQLException e)  //will occur if you did not import the PostGreSQL *.jar file with drivers
        {
            System.out.println(e);
        }
        return aConnection.get();
    }
}

