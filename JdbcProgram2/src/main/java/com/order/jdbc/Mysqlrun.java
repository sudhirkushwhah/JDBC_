package com.order.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Mysqlrun {
	public void play() {
		String urlString = "jdbc:mysql://localhost:3306/collage";
		String userString = "root";
		String passkeyString = "Test@123";
		String query = "select * from students";
		

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("load class");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(urlString, userString, passkeyString);
			Statement statement = connection.createStatement();
			ResultSet eResultSet = statement.executeQuery(query);

			while (eResultSet.next()) {
				String name = eResultSet.getNString("name");
				Integer fee = eResultSet.getInt("Fee");
				Integer age = eResultSet.getInt("age");
				
				System.out.println("name :" + name + " age :" + age + " fee:" + fee);

			}
			eResultSet.close();
			statement.close();
			connection.close();
			System.out.println("database close successfully");
			

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}
