package com.order.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class RegisterStu {
	static String urlString = "jdbc:mysql://localhost:3306/collage";
	static String userString = "root";
	static String passwordString = "Test@123";
	static String queryString = "INSERT INTO kodewala_academy(name, passoutyear, city, feestr) VALUES (?, ?, ?, ?)";

	public static void enrollStudent() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			System.out.println("WELCOME TO KODEWALA ACADEMY TO MAKE FUTURE SECURE !");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			Connection connection = DriverManager.getConnection(urlString, userString, passwordString);
			connection.setAutoCommit(false);
			try {
				PreparedStatement preparedStatement = connection.prepareStatement(queryString);
				Scanner scanner = new Scanner(System.in);
				while (true) {
					System.out.println();
					System.out.print("Enter Student Name : ");
					String name = scanner.nextLine();
					System.out.print("Passout Year : ");
					int year = scanner.nextInt();
					scanner.nextLine();
					System.out.print("Student Collage City : ");
					String city = scanner.nextLine();
					System.out.print("Ammout Paid For JavaCourse : ");
					double feestr = scanner.nextDouble();
					scanner.nextLine();

					preparedStatement.setString(1, name);
					preparedStatement.setInt(2, year);
					preparedStatement.setString(3, city);
					preparedStatement.setDouble(4, feestr);
					preparedStatement.addBatch();
					System.out.print("Can Enroll More Students Y/N : ");
					String decision = scanner.nextLine();
					if (decision.toUpperCase().equalsIgnoreCase("N")) {
						break;
					}
				}
				int[] batchstudent = preparedStatement.executeBatch();
				connection.commit();
				System.out.println("Student Enrolled Successfully : " + batchstudent.length);

				preparedStatement.close();

			} catch (Exception e) {
				e.printStackTrace();
			}
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		enrollStudent();
	}

}
