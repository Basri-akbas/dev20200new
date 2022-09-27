package com.deneme.BosturDeneyebilirsin.api;

import com.deneme.BosturDeneyebilirsin.entity.User;
import com.deneme.BosturDeneyebilirsin.jdbc.JdbcDbConnector;
import com.deneme.BosturDeneyebilirsin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.sql.SQLException;
import java.util.*;

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
    public ResponseEntity<Map<String,Long>> save100Users(){
        Long sum= userService.save100User();

        Map<String,Long> map=new HashMap<>();
        map.put("Toplam kullanici sayisi", sum);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/ua/{id}")
    public ResponseEntity<List<List>> findUserByIdUndAdress(@PathVariable("id") int id) throws SQLException, ClassNotFoundException {
        List<List> sonuc=new ArrayList<>();
        JdbcDbConnector jb=new JdbcDbConnector();
        sonuc.add(jb.getUserUndAdres1(id));


        return new ResponseEntity<>(sonuc,HttpStatus.OK);
    }

}
