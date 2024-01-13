package com.example.usersapps.reposirtory;

import com.example.usersapps.entityes.Address;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressReposiroty extends CrudRepository <Address,Integer> {
    @Query("Select a FROM Address a WHERE a.profile.user.id=?1 AND a.profile.id=?2")
    List<Address>findByProfileId(Integer userId , Integer profileId);
}
