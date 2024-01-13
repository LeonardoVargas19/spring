package com.example.usersapps.services;

import com.example.usersapps.entityes.Rol;
import com.example.usersapps.entityes.UserInRow;
import com.example.usersapps.entityes.Users;
import com.example.usersapps.reposirtory.ProfileRepository;
import com.example.usersapps.reposirtory.RowRepository;
import com.example.usersapps.reposirtory.UserInRolRepository;
import com.example.usersapps.reposirtory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class UserInRowServices {
    @Autowired
    private RowRepository rowRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ProfileRepository profileRepository;
     @Autowired
    private UserInRolRepository userInRolRepository;


    public List<UserInRow> assigneUserRol(Integer userId, Integer profileid) {

        return userInRolRepository.findByUsersAndRow(userId,profileid);

    }

    public UserInRow createUserInRol(UserInRow userInRowData) {
        Users user = userRepository.findById(userInRowData.getUsers().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Usuario no encontrado"));

        Rol role = rowRepository.findById(userInRowData.getRole().getId())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Rol no encontrado"));

        UserInRow newUserInRow = new UserInRow();
        newUserInRow.setUsers(user);
        newUserInRow.setRole(role);

        return userInRolRepository.save(newUserInRow);
    }


}
