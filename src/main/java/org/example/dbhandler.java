package org.example;
import org.example.models.Attendance;
import org.example.models.Grade;
import org.example.models.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbhandler {
    //declaring table names
    public static final String Table_Users = "User";
    public static final String Table_class = "Grade";
    public static final String Table_attendance = "Attendance";

    //declaring column
    public static final String User_ID = "user_id";
    public static final String Column_username = "username";
    public static final String Column_password = "password";
    public static final String Class_Id = "gradeId";
    public static final String Class_name = "className";
    public static final String status = "status";
    public static final String Class_id_attendance = "classId";
    public static final String User_id_attendance = "userId";

    //database_connection
    public static Connection connect() {
        Connection connect = null;

        String url = "jdbc:sqlite:src/main/resources/database/Attendance.db";

        try {
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connect;
    }
    public static void addUsers(User modeUser, Connection connection){

        String sql = "INSERT INTO " + Table_Users + "("+ Column_username + "," + Column_password + " ) " +
                "VALUES(?,?)";

//        insert into tableName (name,contact,email) values("RAM",984321651,p@gmail.com)
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, modeUser.getUsername());
            pstmt.setString(2, modeUser.getPassword());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void addGrade(Grade modeGrade, Connection connection){

        String sql = "INSERT INTO " + Table_class + "("+ Class_name + " ) " + "VALUES(?)";

//        insert into tableName (name,contact,email) values("RAM",984321651,p@gmail.com)
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, modeGrade.getClassName());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    public static void Take_attendance(Attendance modeattendance, Connection connection){

        String sql = "INSERT INTO " + Table_attendance + "("+ Class_id_attendance + "," + User_id_attendance + "," + status + " ) " + "VALUES(?,?,?)";

//        insert into tableName (name,contact,email) values("RAM",984321651,p@gmail.com)
        try{
            PreparedStatement pstmt = connection.prepareStatement(sql);
            pstmt.setString(1, modeattendance.getClassId());
            pstmt.setString(2, modeattendance.getUserId());
            pstmt.setString(3, modeattendance.getStatus());
            pstmt.executeUpdate();

            pstmt.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
