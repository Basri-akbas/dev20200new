package com.deneme.BosturDeneyebilirsin.repository;


import com.deneme.BosturDeneyebilirsin.entity.Book;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Qualifier("books")
@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllBy();

}
