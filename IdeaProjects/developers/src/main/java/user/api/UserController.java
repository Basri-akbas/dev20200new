package user.api;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import user.entity.User;
import user.jdbc.JdbcDbConnector;
import user.service.UserService;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    // TODO request body hicbir zaman bir entity class olmamali,
    //  buna uygun bir request class olusturmamiz gerekiyor ki icinde ID olmasin.
    //  ID database tarafindan atanacak.
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
    public ResponseEntity<Object> findUserById(@PathVariable("id") Long id){
        Optional<User> user=userService.getuserById(id);
        if (user.get().getAdres()==null){
            return new ResponseEntity<>("adres bulunamadi",HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(user,HttpStatus.OK);
    }

    //update user
    @PutMapping("/update")
    // TODO request body degistirilmeli, ID update edilmemeli
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
    public ResponseEntity<List<List>> findUserByIdUndAdress(@PathVariable Long id) throws SQLException, ClassNotFoundException {
        List<List> sonuc=new ArrayList<>();
        JdbcDbConnector jb=new JdbcDbConnector();
        sonuc.add(jb.getUserUndAdres1(id));


        return new ResponseEntity<>(sonuc,HttpStatus.OK);
    }

}