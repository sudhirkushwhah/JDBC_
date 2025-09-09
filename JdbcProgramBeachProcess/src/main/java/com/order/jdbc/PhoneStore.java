package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class PhoneStore {
	
	public static void brands() {
		String url = "jdbc:mysql://localhost:3306/Pointer";
		String ues = "root";
		String password = "Test@123";
		String query = "INSERT INTO phone_collection(brand_name, model_number, price) VALUES (? ,?, ?)";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(url, ues, password);
			connection.setAutoCommit(false);
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, "realme");
			preparedStatement.setString(2, "c2");
			preparedStatement.setDouble(3, 12000.0);
			preparedStatement.addBatch();
			
			preparedStatement.setString(1, "redmi");
			preparedStatement.setString(2, "note pro");
			preparedStatement.setDouble(3, 22000.0);
			preparedStatement.addBatch();
			
			preparedStatement.setString(1, "moto");
			preparedStatement.setString(2, "g85");
			preparedStatement.setDouble(3, 22000.0);
			preparedStatement.addBatch();
			
			int[] showphone = preparedStatement.executeBatch();
			connection.commit();
			System.out.println("Total collection Today : "+showphone.length);
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
	}
	public static void main(String[] args) {
		brands();
	}

}
