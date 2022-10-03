package com.deneme.BosturDeneyebilirsin.service;

import com.deneme.BosturDeneyebilirsin.entity.AdresDTO;
import com.deneme.BosturDeneyebilirsin.entity.User;
import com.deneme.BosturDeneyebilirsin.entity.UserAdresDTO;
import com.deneme.BosturDeneyebilirsin.jdbc.JdbcDbConnector;
import com.deneme.BosturDeneyebilirsin.repository.UserRepository;
import org.springframework.stereotype.Service;

import javax.security.auth.message.AuthException;
import java.sql.SQLException;
import java.util.Optional;

@Service
public class JdbcService {


     JdbcDbConnector jbdb;


    private UserRepository userRepository;

     public JdbcService(UserRepository userRepository) {

         this.userRepository = userRepository;

     }

    public UserAdresDTO userAdres(Long id)  {
        Optional<User> user;
        AdresDTO adresDTO = null;
        UserAdresDTO userAdresDTO=null;

            user=userRepository.findById(id);

        try{
            adresDTO=jbdb.getAdresById(id);
        }catch (SQLException e){
            System.out.println("database baglantisi kurulamdi");
        }
          /*  if (adresDTO==null){
                 userAdresDTO=new UserAdresDTO(user,adresDTO);
            }
        */


         userAdresDTO=new UserAdresDTO(user,adresDTO);

        return userAdresDTO;
    }
    }
