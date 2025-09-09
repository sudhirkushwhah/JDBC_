package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertQuery {

	private static String url = "jdbc:mysql://localhost:3306/collage";
	private static String userid = "root";
	private static String password = "Test@123";
	private static String queryString = "INSERT INTO students (id, name, age, city, fee) VALUES (?, ?, ?, ?, ?)";

	public static void insert() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");

		try {
			Connection connection = DriverManager.getConnection(url, userid, password);
			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			preparedStatement.setInt(1, 112);
			preparedStatement.setString(2, "Dheeraj");
			preparedStatement.setInt(3, 26);
			preparedStatement.setString(4, "Delhi");
			preparedStatement.setInt(5, 24000);

			int print = preparedStatement.executeUpdate(queryString);
			if (print > 0) {
				System.out.println("affected " + print + " rows");
			} else {
				System.out.println("fail update");
			}

			preparedStatement.close();
			connection.close();
			System.out.println("databases close successfully .....");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		insert();
	}

}
