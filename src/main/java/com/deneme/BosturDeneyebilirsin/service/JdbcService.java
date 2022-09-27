package com.deneme.BosturDeneyebilirsin.service;

import com.deneme.BosturDeneyebilirsin.entity.UserAdresDTO;
import com.deneme.BosturDeneyebilirsin.jdbc.JdbcDbConnector;
import com.deneme.BosturDeneyebilirsin.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.Collection;

@Service
public class JdbcService {


     JdbcDbConnector jbdb;


     public UserAdresDTO userAdresDTO;

     private final static String CAR_NOT_FOUND_MSG = "car with id %d not found";

     public UserAdresDTO userAdres(int id) throws SQLException, ClassNotFoundException {

          return jbdb.getUserUndAdres(id);
     }


}
