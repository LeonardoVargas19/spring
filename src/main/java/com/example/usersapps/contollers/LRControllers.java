package com.example.usersapps.contollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class LRControllers {
    @GetMapping
    public String helloWorld(){
        return "Hola Mundo";
    }
}
