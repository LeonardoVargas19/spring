package com.example.usersapps.contollers;

import com.example.usersapps.entityes.Rol;

import com.example.usersapps.reposirtory.RoleServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rols")
public class RowController {
    @Autowired
    private RoleServices services;

    @GetMapping
    public ResponseEntity <List<Rol>> getRow(){
        return new ResponseEntity<List<Rol>>(services.getRole(), HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Rol> createRol(@RequestBody Rol role){
        return new ResponseEntity<Rol>(services.createRol(role),HttpStatus.CREATED);
    }


    @PutMapping("/{roleid}")
    public ResponseEntity<Rol> updateRol(@PathVariable("roleid") Integer roleid, @RequestBody Rol role){
        return new ResponseEntity<Rol>(services.updateRol(roleid,role),HttpStatus.OK);
    }
    @DeleteMapping("/{roleid}")
    public ResponseEntity<Void> deleteRole(@PathVariable("roleid") Integer roleid){
        services.deleteRole(roleid);

        return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
    }
}
