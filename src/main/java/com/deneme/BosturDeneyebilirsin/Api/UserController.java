package com.deneme.BosturDeneyebilirsin.Api;

import com.deneme.BosturDeneyebilirsin.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(path = "/get")
    public static void getir() {


    }

    @GetMapping(path = "/post")
    public static void gonder() {


    }

}
