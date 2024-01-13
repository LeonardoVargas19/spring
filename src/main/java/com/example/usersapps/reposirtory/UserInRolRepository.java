package com.example.usersapps.reposirtory;

import com.example.usersapps.entityes.UserInRow;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserInRolRepository extends CrudRepository<UserInRow,Integer> {
    @Query("SELECT c FROM UserInRow c WHERE  c.users.id=?1 AND c.role.id=?2")
    List<UserInRow> findByUsersAndRow(Integer userId, Integer profileid);
}
