package com.food.controller;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.sql.*;
import javax.servlet.annotation.WebServlet;

@WebServlet("/ContactServlet")  // Servlet URL mapping
public class ContactServlet extends HttpServlet {

    // Database connection parameters
    private String dbURL = "jdbc:mysql://localhost:3306/food_delivery";  // Change to your DB URL
    private String dbUser = "root";  // Change to your DB username
    private String dbPass = "password";  // Change to your DB password

    // This method will handle form submission and store data in the database
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Get form parameters
        String name = request.getParameter("cname");
        String email = request.getParameter("email");
        String message = request.getParameter("address");  // "address" is the name used for the message field in your form.

        // SQL query to insert data into the database
        String query = "INSERT INTO feedback (name, email, message) VALUES (?, ?, ?)";

        // Set response content type
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        Connection conn = null;
        PreparedStatement pstmt = null;

        try {
            // Step 1: Establish database connection
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection(dbURL, dbUser, dbPass);

            // Step 2: Prepare and execute the SQL statement
            pstmt = conn.prepareStatement(query);
            pstmt.setString(1, name);
            pstmt.setString(2, email);
            pstmt.setString(3, message);

            int result = pstmt.executeUpdate();

            // Step 3: Check if the insert was successful and provide feedback to the user
            if (result > 0) {
                out.println("<h2>Your feedback has been successfully submitted!</h2>");
            } else {
                out.println("<h2>Error: Unable to submit feedback. Please try again later.</h2>");
            }

        } catch (Exception e) {
            e.printStackTrace();
            out.println("<h2>Error: " + e.getMessage() + "</h2>");
        } finally {
            // Step 4: Close the database connection
            try {
                if (pstmt != null) {
                    pstmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
