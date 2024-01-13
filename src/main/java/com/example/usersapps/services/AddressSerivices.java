package com.example.usersapps.services;

import com.example.usersapps.entityes.Address;
import com.example.usersapps.entityes.Profile;
import com.example.usersapps.reposirtory.AddressReposiroty;
import com.example.usersapps.reposirtory.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class AddressSerivices {
    @Autowired
    private AddressReposiroty addressReposiroty;
    @Autowired
    private ProfileRepository profileRepository;


    public List<Address> findByAddressesByProfileIdAndUserId(Integer userId, Integer profileId) {
        return addressReposiroty.findByProfileId(userId,profileId);
    }

    public Address createAdresses(Integer userId, Integer profileId, Address address) {
        Optional<Profile> result = profileRepository.findByUserIdAndProfileId(userId, profileId);
        if(result.isPresent()){
            address.setProfile(result.get());
            return addressReposiroty.save(address);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("Profile %d  and user %d not found",profileId,userId));
        }

    }
}
