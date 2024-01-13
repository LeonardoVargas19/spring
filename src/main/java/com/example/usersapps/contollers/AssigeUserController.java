package com.example.usersapps.contollers;

import com.example.usersapps.entityes.UserInRow;
import com.example.usersapps.services.UserInRowServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/{userid}/profile/{profileid}/userInRow")
public class AssigeUserController {

    @Autowired
    private UserInRowServices userInRowServices;

   @GetMapping
    public ResponseEntity<List<UserInRow>> assigneUserRol (@PathVariable("userid") Integer userId , @PathVariable("profileid") Integer profileid ){
       return new ResponseEntity<List<UserInRow>>(userInRowServices.assigneUserRol(userId,profileid),HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<UserInRow> createUserInRow(@RequestBody UserInRow userInRow) {
        // Lógica para crear la instancia, probablemente utilizando un servicio
        UserInRow createdUserInRow = userInRowServices.createUserInRol(userInRow);
        return new ResponseEntity<>(createdUserInRow, HttpStatus.CREATED);
    }


}
