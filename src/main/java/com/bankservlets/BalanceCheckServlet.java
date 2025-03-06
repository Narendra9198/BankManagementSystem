package com.bankservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/BalanceCheckServlet")
public class BalanceCheckServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private static final String url = "jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
    private static final String select = "SELECT amount FROM bankuserdetails WHERE email_Id = ? AND user_pin = ?";

    public BalanceCheckServlet() {}
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.sendRedirect("userDashboard.jsp"); // Redirect to the login page
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String email = (String) session.getAttribute("email");
        Integer pin = (Integer) session.getAttribute("pin"); // Use Integer to handle potential null values

        // Debug: Log the session attributes
        System.out.println("Session email: " + email);
        System.out.println("Session pin: " + pin);

        if (email == null || pin == null) {
            request.setAttribute("errorMessage", "Session expired or invalid. Please log in again.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("userLogin.jsp"); // Redirect to login
            dispatcher.forward(request, response);
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection connection = DriverManager.getConnection(url)) {
                PreparedStatement preparedStatement = connection.prepareStatement(select);
                preparedStatement.setString(1, email);
                preparedStatement.setInt(2, pin);

                ResultSet resultSet = preparedStatement.executeQuery();
                if (resultSet.next()) {
                    double balance = resultSet.getDouble("amount");
                    System.out.println("Balance retrieved: " + balance); // Debug log
                    request.setAttribute("balance", balance);
                    RequestDispatcher dispatcher = request.getRequestDispatcher("checkBalance.jsp");
                    dispatcher.forward(request, response);
                } else {
                    System.out.println("No account found for provided credentials."); // Debug log
                    request.setAttribute("errorMessage", "No account found with provided credentials.");
                    RequestDispatcher dispatcher = request.getRequestDispatcher("userDashboard.jsp");
                    dispatcher.forward(request, response);
                }
            }
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found: " + e.getMessage());
            request.setAttribute("errorMessage", "Database driver error. Please contact support.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
            dispatcher.forward(request, response);
        } catch (SQLException e) {
            System.err.println("SQL error: " + e.getMessage());
            request.setAttribute("errorMessage", "Database error occurred. Please try again later.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("errorPage.jsp");
            dispatcher.forward(request, response);
        }
    }
}
