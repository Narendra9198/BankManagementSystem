package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.model.BankUserRegisterDetails;

public class UserBalanceDao {
	private static final String url="jdbc:mysql://localhost:3306/magadhabank?user=root&password=9198";
	private static final String select="select * from bankuserdetails where email_Id=? and user_pin=?";
	public void checkBalance() {
		
		
	}

}
