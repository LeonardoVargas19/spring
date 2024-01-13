package com.example.usersapps.contollers;

import com.example.usersapps.entityes.Address;
import com.example.usersapps.services.AddressSerivices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user/{userid}/profile/{profileid}/addresses")
public class AddressController {
    @Autowired
    private AddressSerivices addressSerivices;
    @GetMapping
    public ResponseEntity<List<Address>> findByAddressesByProfileIdAndUserId(
            @PathVariable("userid") Integer userId,@PathVariable("profileid") Integer profileId){
        return new ResponseEntity<List<Address>>(addressSerivices.findByAddressesByProfileIdAndUserId(userId,profileId), HttpStatus.OK);


    }
    @PostMapping
    public ResponseEntity<Address> create(@RequestBody Address address ,@PathVariable("userid") Integer userId,@PathVariable("profileid") Integer profileId) {
        return  new ResponseEntity<Address>(addressSerivices.createAdresses(userId,profileId,address),HttpStatus.CREATED);
    }
}
