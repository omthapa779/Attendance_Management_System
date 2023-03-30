package org.example;
import org.example.Model.attendance;
import org.example.Model.class_info;
import org.example.Model.Users;

import java.sql.Connection;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Connection connection = dbhandler.connect();

        String username;
        String password;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Username: ");
        username = scanner.nextLine();
        System.out.println("Enter password: ");
        password = scanner.nextLine();


        Users modelUsers = new Users(-1,username,password);

        dbhandler.addUsers(modelUsers,connection);

    }
}