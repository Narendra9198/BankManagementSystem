package com.bankservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/PinChangeServlet")
public class PinChangeServlet extends HttpServlet {
	
	 private static final String url = "jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	    private static final String update = "update bankuserdetails set user_pin=? WHERE email_Id = ? AND user_pin = ?";
	private static final long serialVersionUID = 1L;
       
    
    public PinChangeServlet() {
       
      
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession httpSession=request.getSession();
		String email=(String) httpSession.getAttribute("email");
		Integer pin=(Integer) httpSession.getAttribute("pin");
		
     int  newpin=Integer.parseInt(request.getParameter("newPin"));
     int confirmpin=Integer.parseInt(request.getParameter("confirmPin"));
     int oldpin=Integer.parseInt(request.getParameter("oldPin"));
		 if (email == null || pin == null) {
	            request.setAttribute("errorMessage", "Session expired or invalid. Please log in again.");
	            RequestDispatcher dispatcher = request.getRequestDispatcher("userLogin.jsp"); // Redirect to login
	            dispatcher.forward(request, response);
	            return;
	        }
		 if(newpin==confirmpin && oldpin==pin) {
		 
		 try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(update);
			preparedStatement.setInt(1, confirmpin);
			preparedStatement.setString(2, email);
			preparedStatement.setInt(3, pin);
			int result=preparedStatement.executeUpdate();
			if(result>0) {
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("CheckUserDetailsServlet");
				requestDispatcher.forward(request, response);
			}
			else {
				RequestDispatcher requestDispatcher=request.getRequestDispatcher("pinchange.jsp");
				requestDispatcher.forward(request, response);
			}
			
		} catch (ClassNotFoundException e) {
		
			e.printStackTrace();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		 }
		 else {
			 RequestDispatcher requestDispatcher=request.getRequestDispatcher("pinchange.jsp");
				requestDispatcher.forward(request, response);
		 }

		
		
		
	}

}
