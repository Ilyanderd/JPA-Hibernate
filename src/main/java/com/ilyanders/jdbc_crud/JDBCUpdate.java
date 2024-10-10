package com.ilyanders.jdbc_crud;

import java.sql.*;
import java.util.Scanner;

public class JDBCUpdate {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PWD);
             Scanner scanner = new Scanner(System.in);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "UPDATE students SET avg_grade = 4 WHERE name = ?")) {

            System.out.println("Enter name: ");
            preparedStatement.setString(1, scanner.next());
            preparedStatement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
