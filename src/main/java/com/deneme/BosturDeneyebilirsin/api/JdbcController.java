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

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map;

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
    public ResponseEntity<UserAdresDTO> findUserByIdUndAdress(@PathVariable("id") int id) throws SQLException, ClassNotFoundException {

        UserAdresDTO userAdresDTO=jdbcService.userAdres(id);


        return new ResponseEntity<>(userAdresDTO, HttpStatus.OK);
    }
}
