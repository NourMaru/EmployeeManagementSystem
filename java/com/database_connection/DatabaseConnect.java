package com.database_connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class DatabaseConnect {
    /**
     * Connection object to open port to db
     */
    private Connection aConnection;

    public Connection initialize() {
        try {
            //Database location
            Class.forName("postgres@localhost.sql"); // loads the JDBC Driver for PostGreSQL

            //database user
            String user = "admin";

            //database user password
            String password = "adminpassword";

            //establishing the database connection
            String url = "jdbc:postgresql://localhost:5432/postgres";
            aConnection = DriverManager.getConnection(url, user, password); // creates the database connection instance

        } catch (ClassNotFoundException | SQLException e)  //will occur if you did not import the PostGreSQL *.jar file with drivers
        {
            e.printStackTrace();
        }
        return aConnection;
    }

    public void terminate() {
        try {
            aConnection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

