package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertQuery {
	public void insert() throws ClassNotFoundException, SQLException {
		String url = "jdbc:mysql://localhost:3306/collage";
		String user = "root";
		String password = "Test@123";
		String query = "INSERT INTO students(id, name, age, city, Fee) VALUES(759, 'Raju', 23, 'Surat', 21000)";

		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, user, password);
		Statement statement = connection.createStatement();
		int affectedquery = statement.executeUpdate(query);
		if (affectedquery > 0) {
			System.out.println("insert succ...: " + affectedquery + "row(s) affected");
		} else {
			System.out.println("insert invalid");
		}
		statement.close();
		connection.close();
		System.out.println("databases close succ....");

	}

}
