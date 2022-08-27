package com.deneme.BosturDeneyebilirsin.Api;

import com.deneme.BosturDeneyebilirsin.service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    /*


    @GetMapping(path = "/get")

    public static void getir() {

    }

    @GetMapping(path = "/post")
    public static void gonder() {

    }*/

    // get, post, put, delete yazilacak ve calisir vaziyette olacak
    // UnitTest yazilacak => JUnit 5 kullanilacak
    // Mockito Framework bakilacak
}
