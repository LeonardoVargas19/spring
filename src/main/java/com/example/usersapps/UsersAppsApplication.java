package com.example.usersapps;

import com.example.usersapps.entityes.Rol;
import com.example.usersapps.entityes.UserInRow;
import com.example.usersapps.entityes.Users;
import com.example.usersapps.model.User;
import com.example.usersapps.reposirtory.RowRepository;
import com.example.usersapps.reposirtory.UserInRolRepository;
import com.example.usersapps.reposirtory.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.management.relation.Role;
import java.util.Random;

@SpringBootApplication
public class UsersAppsApplication implements ApplicationRunner {

    @Autowired
    private Faker faker;
    @Autowired
    private UserRepository repository;
    @Autowired
    private RowRepository rowRepository;
    @Autowired
    private UserInRolRepository userInRolRepository;

    public static void main(String[] args) {

        SpringApplication.run(UsersAppsApplication.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        Rol roler[] = {new Rol("ADMIN"),new Rol("SUPPORT"),new Rol("USER")};
        for (Rol role : roler) {
            rowRepository.save(role);
        }
        for (int i = 0; i < 10000; i++) {
            Users user = new Users();
            user.setUserName(faker.name().username());
            user.setPassword(faker.dragonBall().character());

            Users saveUser = repository.save(user);
            UserInRow userInRow = new UserInRow(saveUser,roler[new Random().nextInt(3)]);
            userInRolRepository.save(userInRow);

        }
    }
}
