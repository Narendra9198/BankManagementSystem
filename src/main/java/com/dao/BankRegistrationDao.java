package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.BankUserRegisterDetails;

public class BankRegistrationDao {
	private static final String url="jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	private static final String insert="insert into bankuserdetails(user_Name, email_Id, aadhar, mobile_number, pan_number, address,"
			+ " gender,   status, amount) values(?,?,?,?,?,?,?,?,?)";
	public int registerUserDetails(BankUserRegisterDetails bankUserRegisterDetails)  {
	int	result=0;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");

		Connection connection	=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(insert);
		preparedStatement.setString(1, bankUserRegisterDetails.getUserName());
		preparedStatement.setString(2, bankUserRegisterDetails.getEmail());
		preparedStatement.setLong(3, bankUserRegisterDetails.getAadhar());
		preparedStatement.setLong(4, bankUserRegisterDetails.getMobile());
		preparedStatement.setString(5, bankUserRegisterDetails.getPannumber());
		preparedStatement.setString(6, bankUserRegisterDetails.getAddress());
		preparedStatement.setString(7, bankUserRegisterDetails.getGender());
		preparedStatement.setString(8, "pending");
		preparedStatement.setDouble(9, 1000);
		 result=preparedStatement.executeUpdate();
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return result ;
	}

}
