package com.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Time;

import com.model.BankStatementDeatils;

public class BankStatementDao {
	private static final String url="jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	private static final String insert="insert into banksatement( Transaction_Amount, "
   + "Balance_Amount, Date_Of_Transaction, Time_Of_Transaction, Transaction_Type, User_Id) values(?,?,?,?,?,?)";
	
	  public int registerStatement(BankStatementDeatils bankStatementDeatils) {
		  int result=0;
		  
		  try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(insert);
			preparedStatement.setDouble(1, bankStatementDeatils.getTransaction_amount());
			preparedStatement.setDouble(2, bankStatementDeatils.getBalance_amount());
			preparedStatement.setDate(3, Date.valueOf(bankStatementDeatils.getDate_of_transaction()));
			preparedStatement.setTime(4, Time.valueOf(bankStatementDeatils.getTime_of_transaction()));
			preparedStatement.setString(5, bankStatementDeatils.getTransaction_type());
			preparedStatement.setInt(6, bankStatementDeatils.getUser_id());
			
			result=preparedStatement.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  
		return result;
		  
	  }

	      
}
