package com.deneme.BosturDeneyebilirsin.service;


import com.deneme.BosturDeneyebilirsin.entity.Book;
import com.deneme.BosturDeneyebilirsin.entity.User;
import com.deneme.BosturDeneyebilirsin.repository.UserRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;


@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;
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
        userRepository.update(id,user.getFirstName(),user.getLastName(),user.getAdress(),user.getMobilePhoneNumber());
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public Long save100User(){
        Faker faker=new Faker();


        for (int i=0;i<100;i++){
            long bookId= Long.valueOf(faker.number().numberBetween(1,500));
            long id=faker.number().randomNumber();
            String name = faker.name().fullName();
            String soyIsim = faker.name().firstName();
            String adres = faker.address().city();
            String telefon = faker.phoneNumber().phoneNumber();
            Date createdDate=faker.date().past(5,TimeUnit.DAYS);
            String email=faker.internet().emailAddress();
            String securityNumber=faker.idNumber().ssnValid();
            boolean isSingle=faker.random().nextBoolean();
            Date  time=faker.date().past(1000, TimeUnit.DAYS);
            Book book=new Book(bookId,"title","writer",time, "555","version",true);
            User user=new User(id,book,createdDate,name,soyIsim,adres,email,telefon,securityNumber,isSingle);

            userRepository.save(user);
        }
        return userRepository.count();
    }

    public Long getCount() throws Exception {
        Faker faker = new Faker();

        for(int i=0; i<100; i++){
            User user = new User();
            user.setAdress(faker.address().fullAddress());
            user.setEmail(faker.internet().emailAddress());
            user.setSingle(faker.bool().bool());
            user.setLastName(faker.name().lastName());
            user.setFirstName(faker.name().firstName());
            user.setCreatedDate(null);

            userRepository.save(user);
        }

        Long count = userRepository.count();
        return count;
    }
}
