package user.service;

import java.sql.SQLException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.entity.AdresDTO;
import user.entity.User;
import user.entity.UserAdresDTO;
import user.jdbc.JdbcDbConnector;
import user.repository.UserRepository;

@Service
public class JdbcService {



    JdbcDbConnector jbdb;


    private UserRepository userRepository;

    public JdbcService(UserRepository userRepository) {

        this.userRepository = userRepository;

    }

    public UserAdresDTO userAdres(Long id)  {
        Optional<User> user = userRepository.findById(id);
        AdresDTO adresDTO = null;
        UserAdresDTO userAdresDTO=null;

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
