package com.example.usersapps.contollers;

import com.example.usersapps.model.User;
import com.example.usersapps.services.UserServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
public class UserControllerList {
    @Autowired
    private UserServices userServices;
    @GetMapping
    public ResponseEntity<List<User>> getUsers(@RequestParam(value = "strarWith",required = false) String strarWith ){
        return new ResponseEntity<>(userServices.getUsers(strarWith), HttpStatus.OK);
    }

    @GetMapping(value = "/{userName}")
    public ResponseEntity<User> getUserByUserName(@PathVariable("userName") String userName){
        return new ResponseEntity<>(userServices.getUserByUsername(userName),HttpStatus.OK);
    }
    @PostMapping()
    public ResponseEntity<User> createUser (@RequestBody User user){
        return new ResponseEntity<>(userServices.createUser(user),HttpStatus.CREATED);
    }
    @PutMapping(value = "/{userName}")
    public ResponseEntity<User> updateUser(@PathVariable("userName" )String userName,@RequestBody User user){
        return new ResponseEntity<>(userServices.updateUser(user,userName),HttpStatus.OK);
    }
    @DeleteMapping(value = "/{userName}")
    public ResponseEntity<Void> deleteUser(@PathVariable("userName") String userName){
        userServices.deleteUser(userName);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
