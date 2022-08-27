package com.deneme.BosturDeneyebilirsin.Api;

import com.deneme.BosturDeneyebilirsin.Entity.User;
import com.deneme.BosturDeneyebilirsin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    //add user
   @PostMapping("/add")
    public ResponseEntity<User> addNewUser(@RequestBody User user){
        User newUser = userService.addNewUser(user);
        return  new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


   //get All user
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> getAllUser = userService.getAllUser();
        return new ResponseEntity<>(getAllUser,HttpStatus.OK);
    }

    //get user by id
    @GetMapping("find/{id}")
    public ResponseEntity<User> findUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //update user
    @PutMapping("/update")
    public ResponseEntity<User> updateUser(@RequestBody User user){
        User updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser,HttpStatus.OK);
    }

    //delete User by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable("id") Long id){
        userService.deleteUserById(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
