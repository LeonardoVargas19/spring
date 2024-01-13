package com.example.usersapps.contollers;

import com.example.usersapps.entityes.Users;
import com.example.usersapps.services.UserService;
import io.micrometer.core.annotation.Timed;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserService services;
    @GetMapping
    @Timed("get.users")
    public ResponseEntity<Page<Users>> getUsers(@RequestParam(required = false,value = "pages",defaultValue = "0") int pages, @RequestParam(required = false,value = "size",defaultValue = "1000") int sizes){
        return new ResponseEntity<>(services.getUsers(pages, sizes), HttpStatus.OK);
    }



    @GetMapping("/usernames")
    public ResponseEntity<List<String>> getUsersNames(){
        return new ResponseEntity<>(services.getUsernames(),HttpStatus.OK);

    }


    @GetMapping("/{userId}")
    public ResponseEntity<Users> getUseById(@PathVariable("userId") Integer user){
        return new ResponseEntity<>(services.getUserById(user), HttpStatus.OK);
    }

    @GetMapping("username/{username}")
    public ResponseEntity<Users> getUseById(@PathVariable("username") String userName){
        return new ResponseEntity<>(services.getUserByUsername(userName), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Users> Authentication (@RequestBody  Users user ){
        return  new ResponseEntity<>(services.getUserNameAndPassword(user.getUserName(), user.getPassword()),HttpStatus.OK);
    }
    @DeleteMapping("/username")
    public ResponseEntity<Void>deleteUser(@PathVariable("userName" )String userName){
        services.deleteUsersByUsername(userName);
     return  new ResponseEntity<>(HttpStatus.NO_CONTENT);


    }


}
