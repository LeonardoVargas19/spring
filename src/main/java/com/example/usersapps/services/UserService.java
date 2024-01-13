package com.example.usersapps.services;

import com.example.usersapps.entityes.Users;
import com.example.usersapps.reposirtory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public Page<Users> getUsers(int pages, int sizes){

        return   userRepository.findAll(PageRequest.of(pages,sizes));
    }
    public Users getUserById(Integer id){
       return userRepository.findById(id).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %d not Found",id)));
    }
    @Cacheable("users")
    public Users getUserByUsername(String username){
        return userRepository.findByUserName(username).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %d not Found",username)));
    }
    public Users getUserNameAndPassword(String userNanme ,String password){
        return  userRepository.findByUserNameAndPassword(userNanme,password).orElseThrow(()-> new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User Not Found")));
    }

    public List<String> getUsernames(){

        return userRepository.findByUsernames();

    }
    @CacheEvict("users")
    public void deleteUsersByUsername(String username){
        Users user = getUserByUsername(username);
        userRepository.delete(user);
    }
}
