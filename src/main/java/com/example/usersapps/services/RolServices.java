package com.example.usersapps.services;

import com.example.usersapps.reposirtory.RowRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolServices {
    @Autowired
    private RowRepository rowRepository;
}
