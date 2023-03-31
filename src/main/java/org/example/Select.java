package org.example;

import java.sql.*;

public class Select {
    public static void main(String[] args) {
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:src/main/resources/database/Attendance.db");

            statement = connection.createStatement();

            resultSet = statement.executeQuery("SELECT * FROM User");

            while (resultSet.next()) {
                int id = resultSet.getInt("studentId");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");

                System.out.println("ID: " + id + ", Name: " + username + ", Password: " + password);
            }
            System.out.println("\n");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Grade");

            while (resultSet.next()){
                int id = resultSet.getInt("gradeId");
                String className = resultSet.getString("className");

                System.out.println("ID: " + id + ", Class name: " + className);
            }
            System.out.println("\n");

            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM Attendance");

            while (resultSet.next()){
                int id = resultSet.getInt("id");
                int classId = resultSet.getInt("classId");
                int userId = resultSet.getInt("userId");
                String status = resultSet.getString("status");


                System.out.println("ID: "+ id + ", Class id: "+ classId + ", User id: "+ userId + ", Status: " + status);
            }


        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
