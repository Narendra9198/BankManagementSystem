package com.model;

public class BankStatementDeatils {
	private int transaction_id;
	private double transaction_amount;
	private double balance_amount;
	private String date_of_transaction;
	private String time_of_transaction;
	private String transaction_type;
	private int user_id;
	public BankStatementDeatils(double transaction_amount, double balance_amount, String date_of_transaction,
			String time_of_transaction, String transaction_type, int user_id ,int transaction_id) {
		this.transaction_id=transaction_id;
		this.transaction_amount = transaction_amount;
		this.balance_amount = balance_amount;
		this.date_of_transaction = date_of_transaction;
		this.time_of_transaction = time_of_transaction;
		this.transaction_type = transaction_type;
		this.user_id = user_id;
	}
	
	public BankStatementDeatils() {
		
	}
	
	

	public int getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(int transaction_id) {
		this.transaction_id = transaction_id;
	}

	public double getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(double transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public double getBalance_amount() {
		return balance_amount;
	}
	public void setBalance_amount(double balance_amount) {
		this.balance_amount = balance_amount;
	}
	public String getDate_of_transaction() {
		return date_of_transaction;
	}
	public void setDate_of_transaction(String date_of_transaction) {
		this.date_of_transaction = date_of_transaction;
	}
	public String getTime_of_transaction() {
		return time_of_transaction;
	}
	public void setTime_of_transaction(String time_of_transaction) {
		this.time_of_transaction = time_of_transaction;
	}
	public String getTransaction_type() {
		return transaction_type;
	}
	public void setTransaction_type(String transaction_type) {
		this.transaction_type = transaction_type;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}

	
	
	

}
