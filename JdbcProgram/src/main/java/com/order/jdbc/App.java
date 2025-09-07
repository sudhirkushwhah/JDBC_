package com.order.jdbc;

import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		MysqlProgram program = new MysqlProgram();
		program.mysql();
		System.out.println("Hello World!");
	}
}
