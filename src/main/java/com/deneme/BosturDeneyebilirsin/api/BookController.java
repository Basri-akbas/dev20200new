package com.deneme.BosturDeneyebilirsin.api;


import com.deneme.BosturDeneyebilirsin.entity.Book;
import com.deneme.BosturDeneyebilirsin.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Controller
@RequestMapping("/book")
public class BookController {

    @Autowired
    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping("/addBook")
    public ResponseEntity<Map<String,Long>> addBook(){
        Long sum= bookService.addBook();

        Map<String,Long> map=new HashMap<>();
        map.put("Toplam kitap sayisi", sum);
        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Book>> getAllBooks(){
        List<Book> books=bookService.getAllBooks();

        return new ResponseEntity<>(books,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Book>> findUserById(@PathVariable("id") Long id){
        Optional<Book> book=bookService.getBookById(id);

        return new ResponseEntity<>(book,HttpStatus.OK);
    }
}
