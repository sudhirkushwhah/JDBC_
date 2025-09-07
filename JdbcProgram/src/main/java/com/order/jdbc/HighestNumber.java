package com.order.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class HighestNumber {
	private static String url = "jdbc:mysql://localhost:3306/collage";
	private static String user = "root";
	private static String password = "Test@123";
	private static String queryString = "SELECT DISTINCT age FROM students ORDER BY age DESC LIMIT 1 OFFSET 1";
	public static void transformer() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class register succ......");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(queryString);
		while(resultSet.next()) {
			System.out.println(resultSet.getInt(1));
		}
	}
	public static void main(String[] args) throws SQLException {
		transformer();
	}

}
