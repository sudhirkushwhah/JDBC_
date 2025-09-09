package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class BookStore {
	static String urlString = "jdbc:mysql://localhost:3306/collage";
	static String userString = "root";
	static String passwordString = "Test@123";
	static String queryString = "INSERT INTO book_library(book_name, book_author, book_standard,  book_price) VALUES (?, ?, ?, ?)";

	public static void library() {
		System.out.println("-------- LIBRARY-----------");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(urlString, userString, passwordString);
			connection.setAutoCommit(false);

			PreparedStatement preparedStatement = connection.prepareStatement(queryString);
			Scanner scanner = new Scanner(System.in);
			while (true) {
				System.out.println();
				System.out.print("Enter Book Name : ");
				String book = scanner.nextLine();
				System.out.print("Enter Book Author : ");
				String writer = scanner.nextLine();
				System.out.print("Book for Class : ");
				String level = scanner.nextLine();
				System.out.print("Enter Book Price : ");
				double price = scanner.nextDouble();
				scanner.nextLine();

				preparedStatement.setString(1, book);
				preparedStatement.setString(2, writer);
				preparedStatement.setString(3, level);
				preparedStatement.setDouble(4, price);
				preparedStatement.addBatch();

				System.out.print("Can You Add More Book Y/N : ");
				String decision = scanner.nextLine();
				if (decision.equalsIgnoreCase("N")) {
					break;
				}
			}
			int[] booklibrary = preparedStatement.executeBatch();
			connection.commit();
			System.out.println("book add successfully : " + booklibrary.length);
			preparedStatement.close();
			connection.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		library();
	}

}
