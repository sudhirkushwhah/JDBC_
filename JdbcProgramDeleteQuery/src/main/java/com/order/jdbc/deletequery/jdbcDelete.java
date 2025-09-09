package com.order.jdbc.deletequery;

import java.sql.Statement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbcDelete {
	String urlString = "jdbc:mysql://localhost:3306/collage";
	String userString = "root";
	String passkeyString = "Test@123";
	String query = "Delete from students where Fee > 40000";

	public void deleteQuery() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("class loaded succ...");

		try {
			Connection connection = DriverManager.getConnection(urlString, userString, passkeyString);
			Statement statement = connection.createStatement();
			int rowaffected = statement.executeUpdate(query);
			if (rowaffected > 0) {
				System.out.println("Deletion succeffully :" + rowaffected + " row(s) affected.");
			} else {
				System.out.println("deletion faile");
			}

			statement.close();
			connection.close();
			System.out.println();
			System.out.println("clear database");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
