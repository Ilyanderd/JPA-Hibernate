package com.ilyanders.jdbc_crud;

import com.ilyanders.entity.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCSelect {
    static final String DB_URL = "jdbc:mysql://localhost:3306/test_db";
    static final String USER = "jpauser";
    static final String PWD = "jpapwd";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PWD);
             PreparedStatement preparedStatement = connection.prepareStatement(
                     "SELECT * FROM students WHERE avg_grade = ?")) {
            preparedStatement.setDouble(1, 4.0);

            ResultSet resultSet = preparedStatement.executeQuery();

            List<Student> students = new ArrayList<>();

            while (resultSet.next()) {
                Student student = new Student();
                student.setId(resultSet.getLong("id"));
                student.setName(resultSet.getString("name"));
                student.setSurname(resultSet.getString("surname"));
                student.setAvgGrade(resultSet.getDouble("avg_grade"));

                students.add(student);
            }

            System.out.println(students);

            resultSet.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
