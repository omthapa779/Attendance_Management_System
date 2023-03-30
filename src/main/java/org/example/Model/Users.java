package org.example.Model;

import java.util.TimeZone;

public class Users {
    public int id;
    public String Username;
    public String Password;

    public Users(int id, String username, String password) {
        this.id = id;
        Username = username;
        Password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
