package com.deneme.BosturDeneyebilirsin.service;

import com.deneme.BosturDeneyebilirsin.Entity.User;
import com.deneme.BosturDeneyebilirsin.Repository.UserRepository;
import com.github.javafaker.Faker;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Optional;
import java.util.Random;


@Service
public class UserService {

    private final UserRepository userRepository;


    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void register(User user) {

        userRepository.save(user);
    }

    public List<User> getAllUsers(){
        return userRepository.findAll();
    }

    public Optional<User> getuserById(Long id){
        return userRepository.findById(id);
    }

    public void updateUser(Long id,User user){
        Optional<User> userDetails = userRepository.findById(id);
        userRepository.update(id,user.getName(),user.getSoyIsim(),user.getAdres(),user.getTelefon());
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
    
    public Integer save100User(){
        Faker faker=new Faker();
        Random random=new Random();

        for (int i=0;i<100;i++){
            long id=random.nextLong();
            String name = faker.name().fullName();
            String soyIsim = faker.name().firstName();
            String adres = faker.address().city();
            String telefon = faker.phoneNumber().phoneNumber();
           // String book=faker.book().title();
            User user=new User(id,name,soyIsim,adres,telefon);
            userRepository.save(user);
        }
    return userRepository.findAllBy().size();
    }
}
