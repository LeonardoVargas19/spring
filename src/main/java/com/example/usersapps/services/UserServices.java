package com.example.usersapps.services;

import com.example.usersapps.model.User;
import com.github.javafaker.Faker;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserServices {
    @Autowired
    private Faker faker;

    private List<User> users = new ArrayList<>();
    @PostConstruct
    public void init(){
        for (int i =0;i<100;i++) {
            users.add(new User(faker.gameOfThrones().character(), faker.zelda().character(), faker.funnyName().name()));
        } // ---> userName / Password / nikName
    }

    public List<User> getUsers(String startWith) {
        if (startWith == null) {
            return users;
        }
        return users.stream()
                .filter(u -> u.getUserName().startsWith(startWith))
                .collect(Collectors.toList());
    }

    public User getUserByUsername(String userName) {
        return users.stream()
                .filter(u -> u.getUserName().equals(userName))
                .findAny()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("User %s not Found", userName)));
    }

    public User  createUser(User user) throws ResponseStatusException {

       if( users.stream().anyMatch(u->u.getUserName().equals(user.getUserName()))){
          throw  new ResponseStatusException(HttpStatus.CONFLICT,String.format("User %s alredy exists",user.getUserName()));
       }
        users.add(user);

       return  user;
    }

    public User updateUser(User user, String newUsername){
        User userByUsername = getUserByUsername(newUsername);
        userByUsername.setNickName(user.getNickName());
        userByUsername.setPassword(user.getPassword());
        return userByUsername;
    }

    public void deleteUser(String user){
        User userByUsername = getUserByUsername(user);
        users.remove(userByUsername);
    }
}
