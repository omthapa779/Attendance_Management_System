package org.example;

import java.sql.*;

import org.example.models.Attendance;
import org.example.models.Grade;
import org.example.models.User;
import java.util.Scanner;

public class Create {
    public static void main(String args[]) {
        Connection connection = dbhandler.connect();

        String username;
        String password;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();


        User modelUsers = new User(-1, username, password);

        dbhandler.addUsers(modelUsers, connection);


        String classname;

        Scanner scanner1 = new Scanner(System.in);
        System.out.println("Enter Classname: ");
        classname = scanner1.nextLine();

        Grade modelclass = new Grade(-1, classname);

        dbhandler.addGrade(modelclass, connection);


        String Class_id;
        String User_id;
        String Status;

        System.out.println("------------------------------ ");
        System.out.println("For Class_id and User_id please run Select.java. If The user's information is not available create one.");
        System.out.println("------------------------------ ");

        Scanner scanner2 = new Scanner(System.in);
        System.out.println("Enter Class_id: ");
        Class_id = scanner1.nextLine();
        System.out.println("Enter User_id: ");
        User_id = scanner1.nextLine();
        System.out.println("Write Present / Absent Accordingly: ");
        Status = scanner1.nextLine();

        Attendance modelattendance = new Attendance(-1, Class_id, User_id, Status);

        dbhandler.Take_attendance(modelattendance, connection);


    }
}
