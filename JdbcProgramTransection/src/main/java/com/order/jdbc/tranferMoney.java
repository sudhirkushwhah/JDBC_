package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;



public class tranferMoney {
	 String url = "jdbc:mysql://localhost:3306/banking_system";
	 String user = "root";
	 String password = "Test@123";
	 String withdrawquery = "SELECT * FROM banking_system WHERE balance = balance - ? account_number = ?";
	 String depositequery = "SELECT * FROM banking_system WHERE balance = balance + ? account_number = ?";

	public void runMoney() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("deiver loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(url, user, password);
			System.out.println("DriverManage establish connection successfully");
			connection.setAutoCommit(false);

			try {
				PreparedStatement withdrawStatement = connection.prepareStatement(withdrawquery);
				PreparedStatement depositeStatement = connection.prepareStatement(depositequery);

				withdrawStatement.setDouble(1, 1000);
				withdrawStatement.setString(2, "account326");
				depositeStatement.setDouble(1, 1000);
				depositeStatement.setString(2, "account986");
				int affectedrow= withdrawStatement.executeUpdate();
				int affectedrowdep= depositeStatement.executeUpdate();
				
				if (affectedrow > 0 && affectedrowdep > 0) {
					connection.commit();
				    System.out.println("transfer successfull");
				}
				else {
					connection.rollback();
					System.out.println("transfer failed!");
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws SQLException {
		tranferMoney tranferMoney = new tranferMoney();
		tranferMoney.runMoney();
	}

}
