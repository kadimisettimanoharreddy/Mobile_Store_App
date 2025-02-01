package com.mobile.app;

import java.io.FileReader;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Jdbc {
    static Connection jdbcconnection() throws ClassNotFoundException, SQLException, IOException {
        Properties props = new Properties();
        
        // Load properties file using FileReader
        FileReader reader = new FileReader("C:\\Users\\MANOHAR REDDY\\Downloads\\dbb.properties");
        props.load(reader);
        reader.close();
        
        // Retrieve values from properties file
        String url = props.getProperty("db.url");
        String user = props.getProperty("db.user");
        String password = props.getProperty("db.password");

        // Establish the database connection
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(url, user, password);
        System.out.println("Connection created successfully");

        return con;
    }
}


