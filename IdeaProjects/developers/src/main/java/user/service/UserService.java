package user.service;

import com.github.javafaker.Faker;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import user.entity.Book;
import user.entity.User;
import user.repository.UserRepository;


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
        userRepository.update(id,user.getName(),user.getSoyIsim(),user.getAdres(),user.getTelefon());
    }

    public void deleteUserById(Long id){
        userRepository.deleteById(id);
    }

    public Long save100User(){
        Faker faker=new Faker();


        for (int i=0;i<10;i++){
            long bookId= Long.valueOf(faker.number().numberBetween(1,50000));
            //long id=faker.number().randomNumber();
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
            User user=new User(book,name,soyIsim,adres,telefon,createdDate,email,securityNumber,isSingle);

            userRepository.save(user);
        }
        return userRepository.count();
    }
}