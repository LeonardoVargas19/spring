package com.example.usersapps.entityes;

import com.example.usersapps.reposirtory.ProfileRepository;
import com.example.usersapps.reposirtory.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class ProfileServises {
    @Autowired
    private ProfileRepository profileRepositoryrepository;
    @Autowired
    private UserRepository userRepository;


    public Profile create(Integer id , Profile profile){
        Optional<Users> result = userRepository.findById(id);
        if(result.isPresent()){
            profile.setUser(result.get());
            return profileRepositoryrepository.save(profile);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,String.format("User %d not found"));
        }

    }

    public Profile getByUserAndProfile(Integer userid, Integer profileid) {
        return profileRepositoryrepository.findByUserIdAndProfileId(userid, profileid)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,
                        String.format("Profile not Found for user %d and profile %d", userid, profileid)));
    }

}
