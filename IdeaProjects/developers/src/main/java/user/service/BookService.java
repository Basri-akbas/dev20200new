package user.service;

import com.github.javafaker.Faker;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;
import org.springframework.stereotype.Service;
import user.entity.Book;
import user.repository.BookRepository;

@Service
public class BookService {

    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public Long addBook(){
        Faker faker=new Faker();
        Date date=new Date();

        long userid= Long.valueOf(faker.number().numberBetween(1,100));
        for (int i=0;i<250;i++){
            long id=faker.number().randomNumber();
            String title=faker.book().title();
            String writer=faker.book().author();
            Date  time=faker.date().past(1000, TimeUnit.DAYS);
            String pageCount=faker.random().hex();
            String version=faker.book().genre();
            boolean isEpubVersionExist=faker.random().nextBoolean();
            // User user=new User(userid, "hsn","bsr","m","1111",date,"h@gmail.com", "2222",true);
            Book book=new Book(id,title,writer,time,pageCount,version,isEpubVersionExist);
            bookRepository.save(book);
        }
        return bookRepository.count();
    }

    public List<Book> getAllBooks(){
        return bookRepository.findAll();
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findById(id);
    }

}