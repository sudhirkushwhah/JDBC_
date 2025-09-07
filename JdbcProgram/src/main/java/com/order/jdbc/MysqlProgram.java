package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MysqlProgram {

	String url = "jdbc:mysql://localhost:3306/collage";
	String username = "root";
	String passkey = "Test@123";
	String query = "select MAX(Fee) from students where Fee < (select MAX(Fee) from students);";
	String updateString = "";

	public void mysql() throws ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		System.out.println("successfull load");

		Connection con;
		try {
			con = DriverManager.getConnection(url, username, passkey);

			Statement statement = con.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			while (resultSet.next()) {
				int Fee = resultSet.getInt(1);
				System.out.println(Fee);
			}
			resultSet.close();
			statement.close();
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
