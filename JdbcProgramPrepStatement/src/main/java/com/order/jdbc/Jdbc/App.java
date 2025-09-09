package com.order.jdbc.Jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class App 
{
	
	public static void prepStatement() throws SQLException {
		String urlString = "jdbc:mysql://localhost:3306/collage";
		String useString ="root";
		String passkeyString = "Test@123";
		String query = "select * from students where name=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		Connection connection =DriverManager.getConnection(urlString, useString, passkeyString);
		PreparedStatement pstate = connection.prepareStatement(query);
		pstate.setString(1, "Prashant");
		pstate.setString(2, "Ravi");
		ResultSet resultSet = pstate.executeQuery();
		while(resultSet.next()) {
		     int id = resultSet.getInt("id");
		     String name = resultSet.getString("name");
		     int age = resultSet.getInt("age");
		     String city = resultSet.getString("city");
		     int fee = resultSet.getInt("fee");
		     System.out.println("id :"+id);
		     System.out.println("name :"+name);
		     System.out.println("age :"+age);
		     System.out.println("city :"+city);
		     System.out.println("fee :"+fee);
		     
		    
		}
		resultSet.close();
		pstate.close();
		connection.close();
		System.out.println("close dateabase succ....");
		
	}
    public static void main( String[] args ) throws SQLException
    {
    	prepStatement();
        System.out.println( "Hello World!" );
    }
}
