package com.deneme.BosturDeneyebilirsin.Api;

import com.deneme.BosturDeneyebilirsin.Entity.User;
import com.deneme.BosturDeneyebilirsin.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }



    @PostMapping("/register")
    public ResponseEntity<Map<String,Boolean>> registerUser(@RequestBody User user){
        userService.register(user);

        Map<String,Boolean>map=new HashMap<>();
        map.put("User registered successfully",true);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }
    //get All user
    @GetMapping("/all")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> users=userService.getAllUsers();

        return new ResponseEntity<>(users,HttpStatus.OK);
    }
    //get user by id
    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable("id") Long id){
        Optional<User> user=userService.getuserById(id);

        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //update user
    @PutMapping("/update")
    public ResponseEntity<String> updateUser(HttpServletRequest request,@Valid @RequestBody User user){
        Long id=(Long) request.getAttribute("id");
        userService.updateUser(id,user);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    //delete User by id
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteUserById(@PathVariable Long id){
        userService.deleteUserById(id);

        return new ResponseEntity<>("success",HttpStatus.OK);
    }

    @PostMapping("/users100")
    public ResponseEntity<Map<String,Integer>> save100Users(){
       Integer sum= userService.save100User();

        Map<String,Integer> map=new HashMap<>();
        map.put("Toplam kullanici sayisi", sum);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

}
