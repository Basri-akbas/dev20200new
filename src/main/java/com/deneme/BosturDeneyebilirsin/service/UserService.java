package com.deneme.BosturDeneyebilirsin.service;

import com.deneme.BosturDeneyebilirsin.Repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
}
