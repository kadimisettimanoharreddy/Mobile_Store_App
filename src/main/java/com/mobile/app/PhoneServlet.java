package com.mobile.app;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jakarta.servlet.http.HttpServlet;

public class PhoneServlet extends HttpServlet {
    public static String[] phonedata(int i) throws ClassNotFoundException, SQLException, IOException {
        String[] arr = new String[5];

        try (Connection con = Jdbc.jdbcconnection();
             PreparedStatement st = con.prepareStatement("SELECT * FROM phone WHERE phoneid = ?")) {
             
            st.setInt(1, i);
            try (ResultSet rs = st.executeQuery()) {
                if (rs.next()) { // Check if there is data
                    arr[0] = rs.getString(2);
                    arr[1] = rs.getString(3);
                    arr[2] = rs.getString(4);
                    arr[3] = rs.getString(5);
                    arr[4] = Integer.toString(rs.getInt(1));
                } else {
                    // Handle the case where no result is found (optional)
                    System.out.println("No phone found with ID: " + i);
                    return null; // or return an empty array, depending on your needs
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Log the error
            throw e; // Optionally rethrow or handle the exception
        }

        return arr;
    }
}

