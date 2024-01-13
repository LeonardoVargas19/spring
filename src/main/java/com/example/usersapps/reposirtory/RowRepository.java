package com.example.usersapps.reposirtory;

import com.example.usersapps.entityes.Rol;
import com.example.usersapps.entityes.UserInRow;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RowRepository extends CrudRepository<Rol,Integer> {

    @Query("SELECT c FROM UserInRow c WHERE  c.users.id=?1 AND c.role.id=?2")
    List<UserInRow> findByUsersAndRow(Integer userId, Integer profileid);
}
