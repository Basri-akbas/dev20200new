package user.repository;


import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import user.entity.Book;

@Qualifier("books")
@Repository
@Transactional
public interface BookRepository extends JpaRepository<Book,Long> {

    List<Book> findAllBy();

}
