package com.model;

public class BankUserRegisterDetails {
	private String userName;
	private String email;
	private long aadhar;
	private long mobile;
	private String pannumber;
	private String address;
	private String gender;
	private String status;
	private long accountNumber;
	private double amount;
	private int userId;
	
	
	
	public BankUserRegisterDetails() {
		
	}
	public BankUserRegisterDetails(String userName, String email, long aadhar, long mobile, String pannumber,
			String address, String gender, String status, long accountNumber, double amount ,int userId) {
		
		this.userName = userName;
		this.email = email;
		this.aadhar = aadhar;
		this.mobile = mobile;
		this.pannumber = pannumber;
		this.address = address;
		this.gender = gender;
		this.status = status;
		this.accountNumber = accountNumber;
		this.amount = amount;
		this.userId=userId;
	}
	
	
	
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getAadhar() {
		return aadhar;
	}
	public void setAadhar(long aadhar) {
		this.aadhar = aadhar;
	}
	public long getMobile() {
		return mobile;
	}
	public void setMobile(long mobile) {
		this.mobile = mobile;
	}
	public String getPannumber() {
		return pannumber;
	}
	public void setPannumber(String pannumber) {
		this.pannumber = pannumber;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getAmount() {
		return amount;
	}
	public void setAmount(double amount) {
		this.amount = amount;
	}
	
	

}
