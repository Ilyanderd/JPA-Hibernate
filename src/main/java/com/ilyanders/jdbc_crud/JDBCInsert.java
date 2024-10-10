package com.ilyanders.jdbc_crud;

import com.ilyanders.entity.Student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class JDBCInsert {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        Student student = new Student("Ilya","Povetkin",5.0);

        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PWD)) {
            PreparedStatement statement = connection.prepareStatement(
                    "INSERT INTO students(name,surname,avg_grade) VALUES (?,?,?)");
            statement.setString(1, student.getName());
            statement.setString(2, student.getSurname());
            statement.setDouble(3, student.getAvgGrade());

            statement.executeUpdate();

            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
