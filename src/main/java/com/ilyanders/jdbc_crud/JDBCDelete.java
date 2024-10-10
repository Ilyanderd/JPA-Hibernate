package com.ilyanders.jdbc_crud;

import java.sql.*;

public class JDBCDelete {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PWD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "DELETE FROM students WHERE name = ?")) {

            preparedStatement.setString(1, "Ilya");
            int deletedRows = preparedStatement.executeUpdate();
            System.out.println("Deleted " + deletedRows + " rows");

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
