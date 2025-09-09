package com.order.jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Update {
	public void updateQuery() {
		String urlString = "jdbc:mysql://localhost:3306/collage";
		String userString = "root";
		String passkeyString = "Test@123";
		String queryString ="Update students set city= 'Noida', age=26 where id=125";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(urlString, userString, passkeyString );
			Statement statement = connection.createStatement();
			int affectedquery = statement.executeUpdate(queryString);
			
			if (affectedquery > 0) {
				System.out.println("update succ... :"+affectedquery+" row(s) affected ");
			}
			else {
				System.out.println("update faile");
			}
			
			statement.close();
			connection.close();
			System.out.println("updation succc....fully");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
