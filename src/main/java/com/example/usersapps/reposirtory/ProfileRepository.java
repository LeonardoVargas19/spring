package com.example.usersapps.reposirtory;

import com.example.usersapps.entityes.Profile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends CrudRepository<Profile,Integer> {
    @Query("SELECT p FROM  Profile p  WHERE p.user.id=?1 AND p.id=?2")
    Optional<Profile> findByUserIdAndProfileId(Integer userid, Integer profileid);
    Optional<Profile> findById(Integer id);

}
