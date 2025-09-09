package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;

public class Driver {

	public static void drivesql() {
		String url = "jdbc:mysql://localhost:3306/collage";
		String username = "root";
		String password = "Test@123";
		String query = "select * from students";
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("class loaded successfully");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement statement = conn.createStatement();

			ResultSet resultSet = statement.executeQuery(query);
			while (resultSet.next()) {
				String name = resultSet.getString("name");
				String city = resultSet.getString("city");
				System.out.println("city :" + city + " name :" + name);

			}
			resultSet.close();
			statement.close();
			conn.close();
			System.out.println();
			System.out.println("jdbc close successfully");

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}
	
	public static void main( String[] args ) throws ClassNotFoundException
    {
		
    	drivesql();
    }
}