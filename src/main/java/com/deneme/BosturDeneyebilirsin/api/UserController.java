package com.deneme.BosturDeneyebilirsin.api;

import com.deneme.BosturDeneyebilirsin.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/get")
    public static void getir() {
    }

    @GetMapping("/get/count")
    public ResponseEntity<Long> getCount() throws Exception{
        Long count = userService.getCount();
        return new ResponseEntity<>(count, HttpStatus.OK);
    }
/*
    @PostMapping("/add")
    public ResponseEntity<String> addUser(@RequestBody User user) throws Exception {
        userService.register(user);
        return new ResponseEntity<>("Eklendi", HttpStatus.CREATED);

    }

    @GetMapping("/get/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) throws Exception{
        User user = userService.findById(id);
            return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(path = "/post")
    public static void gonder() {
    }

    // get, post, put, delete yazilacak ve calisir vaziyette olacak
    // UnitTest yazilacak => JUnit 5 kullanilacak
    // Mockito Framework bakilacak


 */
}
