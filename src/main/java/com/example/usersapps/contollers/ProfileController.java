package com.example.usersapps.contollers;

import com.example.usersapps.entityes.Profile;
import com.example.usersapps.entityes.ProfileServises;
import com.example.usersapps.entityes.Rol;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users/{userid}/profile")
public class ProfileController {
    @Autowired
    private ProfileServises servise;
    @GetMapping("/{profileid}")
    public ResponseEntity<Profile> getById(@PathVariable("userid") Integer userid,@PathVariable("profileid") Integer profileid){
        return new ResponseEntity<Profile>(servise.getByUserAndProfile(userid, profileid), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Profile> create(@PathVariable("userid") Integer userid, @RequestBody Profile profile){
        return new ResponseEntity<Profile>(servise.create(userid, profile), HttpStatus.CREATED);
    }
}
