package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Random;

public class ProcessRequestDao {
	private static final String url="jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	

	public int requestProcess(int userId,String status,long account,int pin) {
		int result=0;
		String update="update bankuserdetails set status=?,user_account_number=?,user_pin=? where userId=?";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		Connection	connection=DriverManager.getConnection(url);
		PreparedStatement preparedStatement=connection.prepareStatement(update);
		preparedStatement.setInt(4, userId);
		preparedStatement.setString(1, status);
		preparedStatement.setLong(2, account);
		preparedStatement.setInt(3, pin);
		 result=preparedStatement.executeUpdate();
		} catch (ClassNotFoundException e) {
			System.out.println("class not found exception");
			
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("sql exception");
			
			e.printStackTrace();
		}
		return result;
	}
	
}
