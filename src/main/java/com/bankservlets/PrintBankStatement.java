package com.bankservlets;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.model.BankStatementDeatils;

@WebServlet("/PrintBankStatement")
public class PrintBankStatement extends HttpServlet {
	private static final String select="select * from banksatement where User_Id=?";
	private static final String url="jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	private static final long serialVersionUID = 1L;
   
    public PrintBankStatement() {
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    HttpSession httpSession = request.getSession();

	    if (httpSession == null || httpSession.getAttribute("userId") == null) {
	        response.sendRedirect("userLogin.jsp");
	        return;
	    }

	    int userId = (int) httpSession.getAttribute("userId");

	    List<BankStatementDeatils> transactions = new ArrayList<>();
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        Connection connection = DriverManager.getConnection(url);
	        PreparedStatement preparedStatement = connection.prepareStatement(select);
	        preparedStatement.setInt(1, userId);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        //         Create formatters for date and time
	        SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat timeFormatter = new SimpleDateFormat("HH:mm:ss");

	        while (resultSet.next()) {
	            //            Convert Date and Time to String
	            String dateOfTransaction = dateFormatter.format(resultSet.getDate("Date_Of_Transaction"));
	            String timeOfTransaction = timeFormatter.format(resultSet.getTime("Time_Of_Transaction"));

	            BankStatementDeatils bankStatementDeatils = new BankStatementDeatils();
	            bankStatementDeatils.setTransaction_id(resultSet.getInt("Transaction_Id"));
	            bankStatementDeatils.setTransaction_amount(resultSet.getDouble("Transaction_Amount"));
	            bankStatementDeatils.setBalance_amount(resultSet.getDouble("Balance_Amount"));
	            bankStatementDeatils.setDate_of_transaction(dateOfTransaction);
	            bankStatementDeatils.setTime_of_transaction(timeOfTransaction); 
	            bankStatementDeatils.setTransaction_type(resultSet.getString("Transaction_Type"));
	            bankStatementDeatils.setUser_id(resultSet.getInt("User_Id"));

	            transactions.add(bankStatementDeatils);
	        }
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    }

	  
	    request.setAttribute("transactions", transactions);
	    request.getRequestDispatcher("bankstatement.jsp").forward(request, response);
	}

}
