package com.order.jdvc.JdbcProgramUpdateQuery;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UpdateQuery {
	String url = "jdbc:mysql://localhost:3306/collage";
	String username = "root";
	String passkey = "Test@123";
	String query = 
	public void change() throws ClassNotFoundException , SQLException{
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, username, passkey);
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeUpdate(query);
	}

}
