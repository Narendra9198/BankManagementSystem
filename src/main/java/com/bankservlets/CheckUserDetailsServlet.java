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

@WebServlet("/CheckUserDetailsServlet")
public class CheckUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 private static final String url = "jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	    private static final String select = "SELECT * FROM bankuserdetails WHERE email_Id = ? AND user_pin = ?";
       
   
    public CheckUserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		String email=(String) httpSession.getAttribute("email");
		Integer pin=(Integer) httpSession.getAttribute("pin");
		
		 if (email == null || pin == null) {
	            request.setAttribute("errorMessage", "Session expired or invalid. Please log in again.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("userLogin.jsp"); // Redirect to login
	            dispatcher.forward(request, response);
	            return;
	        }
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(select);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, pin);
			ResultSet resultSet =preparedStatement.executeQuery();
			if (resultSet.next()) {
			    request.setAttribute("userId", resultSet.getInt("userId"));
			    request.setAttribute("userName", resultSet.getString("user_Name"));
			    request.setAttribute("email", resultSet.getString("email_Id"));
			    request.setAttribute("aadhar", resultSet.getLong("aadhar"));
			    request.setAttribute("mobile", resultSet.getLong("mobile_number"));
			    request.setAttribute("pan", resultSet.getString("pan_number"));
			    request.setAttribute("address", resultSet.getString("address"));
			    request.setAttribute("gender", resultSet.getString("gender"));
			    request.setAttribute("userPin", resultSet.getInt("user_pin"));
			    request.setAttribute("accountNumber", resultSet.getLong("user_account_number"));
			    request.setAttribute("status", resultSet.getString("status"));
			    request.setAttribute("amount", resultSet.getDouble("amount"));

			    RequestDispatcher dispatcher = request.getRequestDispatcher("checkuserdetails.jsp");
			    dispatcher.forward(request, response);
			} else {
			    request.setAttribute("errorMessage", "No details found for the provided email and PIN.");
			    RequestDispatcher dispatcher = request.getRequestDispatcher("error.jsp");
			    dispatcher.forward(request, response);
			}

			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

}
