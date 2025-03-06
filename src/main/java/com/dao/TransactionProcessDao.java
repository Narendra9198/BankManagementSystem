package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import com.model.BankStatementDeatils;

public class TransactionProcessDao {
	BankStatementDeatils bankStatementDeatils=new BankStatementDeatils();
	private static final String url="jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	private static final String select1="select amount,userId from bankuserdetails where email_Id=? and user_pin=?";
	private static final String update1 ="update bankuserdetails set amount=? where email_Id=? and user_pin=?";
	private static final String update2="update bankuserdetails set amount=? where mobile_number=?";
	private static final String select2="select amount,userId from bankuserdetails where mobile_number=?";
	
	public int creditProcess( String email,int pin, double creditamount) {
		int result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(select1);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, pin);
			ResultSet resultSet=preparedStatement.executeQuery();
			double amount=0;
			int userId=0;
			if(resultSet.next()) {
				amount=resultSet.getDouble("amount");
				userId=resultSet.getInt("userId");
			}
			else {
				
			}
			 double updamount=0;
			if(creditamount>0) {
				updamount=amount+creditamount;
			}
			
			//inserting into the bank statement table in the database.
			bankStatementDeatils.setBalance_amount(updamount);
			bankStatementDeatils.setTransaction_amount(creditamount);
			bankStatementDeatils.setTransaction_type("credit");
			bankStatementDeatils.setDate_of_transaction(String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
			bankStatementDeatils.setTime_of_transaction(String.valueOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
			bankStatementDeatils.setUser_id(userId);
			BankStatementDao bankStatementDao=new BankStatementDao();
			bankStatementDao.registerStatement(bankStatementDeatils);
			// update in the database....
			
			
			
			PreparedStatement preparedStatement2=connection.prepareStatement(update1);
			preparedStatement2.setDouble(1, updamount);
			preparedStatement2.setString(2, email);
			preparedStatement2.setInt(3, pin);
			 result=preparedStatement2.executeUpdate();
			return result;
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int debitProcess(String email,int pin,double debitamount) {
		int result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection connection=DriverManager.getConnection(url);
			PreparedStatement preparedStatement=connection.prepareStatement(select1);
			preparedStatement.setString(1, email);
			preparedStatement.setInt(2, pin);
			ResultSet resultSet=preparedStatement.executeQuery();
			double amount=0;
			int userId=0;
			if(resultSet.next()) {
				amount=resultSet.getDouble("amount");
				userId=resultSet.getInt("userId");
			}
			else {
				
			}
			 double updamount1=0;
			if(debitamount>0 && amount >=debitamount) {
				updamount1=amount-debitamount;
			}
			
			//inserting into the bank statement table in the database.
			bankStatementDeatils.setBalance_amount(updamount1);
			bankStatementDeatils.setTransaction_amount(debitamount);
			bankStatementDeatils.setTransaction_type("debit");
			bankStatementDeatils.setDate_of_transaction(String.valueOf(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"))));
			bankStatementDeatils.setTime_of_transaction(String.valueOf(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"))));
			bankStatementDeatils.setUser_id(userId);
			BankStatementDao bankStatementDao=new BankStatementDao();
			bankStatementDao.registerStatement(bankStatementDeatils);
			// update in the database....
			
			
			
			PreparedStatement preparedStatement2=connection.prepareStatement(update1);
			preparedStatement2.setDouble(1, updamount1);
			preparedStatement2.setString(2, email);
			preparedStatement2.setInt(3, pin);
			 result=preparedStatement2.executeUpdate();
			return result;
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	public int transferamountusingmobilenumber(String email, int pin, double transferamount, long mobilenumber) {
	    int result = 0;
	    Connection connection = null;

	    try {
	        // Load MySQL driver
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        connection = DriverManager.getConnection(url);

	        // Fetch recipient details
	        PreparedStatement preStatement = connection.prepareStatement(select2); // Ensure 'select2' fetches amount & userId by mobile
	        preStatement.setLong(1, mobilenumber);
	        ResultSet resSet = preStatement.executeQuery();

	        int recUserId = 0;
	        double addedamount = 0.0;
	        if (resSet.next()) {
	            recUserId = resSet.getInt("userId");
	            addedamount = resSet.getDouble("amount");
	        } else {
	            // If recipient not found, return error
	            return 0;
	        }

	        // Calculate new balance for recipient
	        double recupdtamount = transferamount + addedamount;

	        // Fetch sender details
	        PreparedStatement preparedStatement = connection.prepareStatement(select1); // Ensure 'select1' fetches sender's amount & userId
	        preparedStatement.setString(1, email);
	        preparedStatement.setInt(2, pin);
	        ResultSet resultSet = preparedStatement.executeQuery();

	        int userId = 0;
	        double amount = 0.0;
	        if (resultSet.next()) {
	            userId = resultSet.getInt("userId");
	            amount = resultSet.getDouble("amount");
	        } else {
	            // If sender not found, return error
	            return 0;
	        }

	        // Ensure sufficient balance
	        if (transferamount <= 0 || amount < transferamount) {
	            return 0; // Insufficient funds or invalid transfer amount
	        }

	        // Calculate new balance for sender
	        double updamount1 = amount - transferamount;

	        // Update sender balance
	        PreparedStatement preparedStatement2 = connection.prepareStatement(update1); // Ensure 'update1' updates by email and pin
	        preparedStatement2.setDouble(1, updamount1);
	        preparedStatement2.setString(2, email);
	        preparedStatement2.setInt(3, pin);
	        preparedStatement2.executeUpdate();

	        // Insert debit transaction for sender
	        bankStatementDeatils.setBalance_amount(updamount1);
	        bankStatementDeatils.setTransaction_amount(transferamount);
	        bankStatementDeatils.setTransaction_type("debit");
	        bankStatementDeatils.setDate_of_transaction(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	        bankStatementDeatils.setTime_of_transaction(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	        bankStatementDeatils.setUser_id(userId);
	        BankStatementDao bankStatementDao = new BankStatementDao();
	        bankStatementDao.registerStatement(bankStatementDeatils);

	        // Update recipient balance
	        PreparedStatement preparedStatement3 = connection.prepareStatement(update2); // Ensure 'update2' updates by mobile number
	        preparedStatement3.setDouble(1, recupdtamount);
	        preparedStatement3.setLong(2, mobilenumber);
	        preparedStatement3.executeUpdate();

	        // Insert credit transaction for recipient
	        bankStatementDeatils.setBalance_amount(recupdtamount);
	        bankStatementDeatils.setTransaction_amount(transferamount);
	        bankStatementDeatils.setTransaction_type("credit");
	        bankStatementDeatils.setDate_of_transaction(LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
	        bankStatementDeatils.setTime_of_transaction(LocalTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss")));
	        bankStatementDeatils.setUser_id(recUserId);
	        bankStatementDao.registerStatement(bankStatementDeatils);

	        // Return success
	        result = 1;
	    } catch (ClassNotFoundException | SQLException e) {
	        e.printStackTrace();
	    } finally {
	        try {
	            if (connection != null) {
	                connection.close(); // Close connection
	            }
	        } catch (SQLException ex) {
	            ex.printStackTrace();
	        }
	    }
	    return result;
	}


}
