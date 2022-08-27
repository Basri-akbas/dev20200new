package com.deneme.BosturDeneyebilirsin.service;

import com.deneme.BosturDeneyebilirsin.Entity.User;
import com.deneme.BosturDeneyebilirsin.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //add user
    public User addNewUser(User user){
        return userRepository.save(user);
    }

    //get user all
    public List<User> getAllUser(){
        return userRepository.findAll();
    }

    //get user by id

    public User getUserById(Long id){
        return userRepository.findById(id).get();
    }

    //update user
    public User updateUser(User user){
        return userRepository.save(user);
    }

    //delete user by id
   public void deleteUserById(Long id){
        userRepository.deleteById(id);
   }
}
