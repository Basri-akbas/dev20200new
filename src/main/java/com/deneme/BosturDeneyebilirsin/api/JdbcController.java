package com.deneme.BosturDeneyebilirsin.api;

import com.deneme.BosturDeneyebilirsin.entity.UserAdresDTO;
import com.deneme.BosturDeneyebilirsin.jdbc.JdbcDbConnector;
import com.deneme.BosturDeneyebilirsin.service.JdbcService;
import com.deneme.BosturDeneyebilirsin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;



@Controller
@RequestMapping("/jdbc")
public class JdbcController {

    @Autowired
    private JdbcService jdbcService;

    @Autowired
    public JdbcController(JdbcService jdbcService) {
        this.jdbcService = jdbcService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findUserByIdUndAdress(@PathVariable Long id)  {

        UserAdresDTO userAdresDTO=jdbcService.userAdres(id);

        if (userAdresDTO.getAdresDTO().getId()==null){
            return new ResponseEntity<>("adres bulunamadi",HttpStatus.BAD_REQUEST);
        }
      //  return new ResponseEntity<>(user,HttpStatus.OK);

        return new ResponseEntity<>(userAdresDTO, HttpStatus.OK);
    }
}
