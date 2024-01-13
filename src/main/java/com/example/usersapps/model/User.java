package com.example.usersapps.model;


import com.github.javafaker.FunnyName;
import com.github.javafaker.GameOfThrones;
import com.github.javafaker.Zelda;

public class User {

    private String userName;
    private String password;
    private String nickName;

    public User(String userName, String password, String nickName) {
        this.userName = userName;
        this.password = password;
        this.nickName = nickName;
    }

    public User() {

    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
