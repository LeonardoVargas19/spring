package com.example.usersapps.reposirtory;

import com.example.usersapps.entityes.Profile;
import com.example.usersapps.entityes.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Integer> {
     Optional<Users> findByUserName(String username);
     Optional<Users> findByUserNameAndPassword(String userName, String password);
     @Query("SELECT u.userName FROM Users u")
     List<String> findByUsernames();


}