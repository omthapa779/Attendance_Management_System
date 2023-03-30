package org.example;
import org.example.Model.Users;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class dbhandler {

    //declaring table names
    public static final String Table_Users = "User";
    public static final String Table_class = "class_info";
    public static final String Table_attendance = "attendance";

    //declaring column
    public static final String User_ID = "user_id";
    public static final String Column_username = "username";
    public static final String Column_password = "password";
    public static final String Class_Id = "class_id";
    public static final String Class_name = "class_name";
    public static final String Attendance_id = "attendance_id";
    public static final String Class_id_attendance = "class_id";
    public static final String User_id_attendance = "user_id";

    //database_connection
    public static Connection connect() {
        Connection connect = null;

        String url = "jdbc:sqlite:src/main/resources/database/Attendance_Management_System.db";

        try {
            connect = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return connect;
    }

//getting_user_information
public static int getUserIdfromUser(Connection connection, String user_name) {
        String query = "SELECT * FROM " + Table_Users + " WHERE " + Column_username + " = " + user_name;  //sql for selecting username
      List<Users> users_info = new ArrayList<>(); //creating arraylist for user_information
   try {
       Statement statement = connection.createStatement();
       ResultSet resultset = statement.executeQuery(query);

       while (resultset.next()) {
           int id = resultset.getInt(User_ID);

           Users users1 = new Users(id, "", ""); //for id, username and password
           users_info.add(users1);
       }
   }
   catch(SQLException e){
           System.out.println(e.getMessage());
   }
    return users_info.get(0).getId();
}

    public List<Users> getallusers(Connection connection, String username) {
        String query = "SELECT * FROM " + Table_Users + " WHERE " + Column_username + " like %" + username + "%";
        List<Users> user_info = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                int id = resultSet.getInt(User_ID);
                String name = resultSet.getString(Column_username);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return user_info;
    }

    public static void addUsers(Users modeUser, Connection connection){

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
}
