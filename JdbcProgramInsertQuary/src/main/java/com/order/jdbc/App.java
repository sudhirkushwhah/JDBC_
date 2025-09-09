package com.order.jdbc;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		InsertQuery query = new InsertQuery();
		query.insert();
		
	}
}
