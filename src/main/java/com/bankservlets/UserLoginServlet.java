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
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;








@WebServlet("/UserLoginServlet")
public class UserLoginServlet extends HttpServlet {
	private static final String url="jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	private static final String select="select * from bankuserdetails where email_Id=? and user_pin=?";
	private static final long serialVersionUID = 1L;
       
   
    public UserLoginServlet() {
       
    }

	
	protected void doGet(HttpServletRequestWrapper request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	String email= String.valueOf(request.getParameter("email"));
	
	int pin=Integer.parseInt(request.getParameter("pin"));
	
	
	try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection  connection = DriverManager.getConnection(url);
	    PreparedStatement preparedStatement=connection.prepareStatement(select);
	   
	    preparedStatement.setString(1, email);
	    preparedStatement.setInt(2, pin);
	    ResultSet resultSet=preparedStatement.executeQuery();
	    
	    if(resultSet.next()) {
	    	
	    	HttpSession httpSession=request.getSession();
	    	httpSession.setAttribute("email", email);
	    	httpSession.setAttribute("pin", pin);
	    	httpSession.setAttribute("userId", resultSet.getInt("userId"));
	    	RequestDispatcher requestDispatcher=request.getRequestDispatcher("userDashboard.jsp");
	    	requestDispatcher.forward(request, response);
	    }
	    else {
	    	request.setAttribute("errorMessage", "Invalid credentials. Please try again.");
            request.getRequestDispatcher("userLogin.jsp").forward(request, response);
	    }
	} catch (SQLException e) {
		
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		
		e.printStackTrace();
	}
	
	}

}
