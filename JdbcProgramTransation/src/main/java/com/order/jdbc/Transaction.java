package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Transaction {
	String url = "jdbc:mysql://localhost:3306/banking_system";
	String user = "root";
	String password = "Test@123";
	String withdrawamount = "SELECT banking_system SET balance = balance - ? WHERE account_number = ?";
	String depositeamount = "SELECT banking_system SET balance = balance + ? WHERE account_number = ?";

	public void transfer() throws ClassNotFoundException, SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded successfully :");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("connection estiblish successfully");
			connection.setAutoCommit(false);
			try {
				PreparedStatement withdrawStatement = connection.prepareStatement(withdrawamount);
				PreparedStatement depositeStatement = connection.prepareStatement(depositeamount);
				withdrawStatement.setDouble(1, 500.00);
				withdrawStatement.setString(2, "account548");
				depositeStatement.setDouble(1, 500.00);
				depositeStatement.setString(2, "account986");

				int rowaffectedwithdraw = withdrawStatement.executeUpdate();
				int rowaffecteddeposite = depositeStatement.executeUpdate();

				if (rowaffectedwithdraw > 0 && rowaffecteddeposite > 0) {
					connection.commit();
					System.out.println("transaction successful");
				} else {
					connection.rollback();
				}

			} catch (Exception e) {
				System.out.println("Ops!");
				System.out.println("transaction failed!");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Transaction transaction = new Transaction();
		transaction.transfer();

	}

}
