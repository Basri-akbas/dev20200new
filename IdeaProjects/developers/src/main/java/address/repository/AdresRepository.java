package address.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import address.entity.Adres;

@Repository
public interface AdresRepository extends JpaRepository<Adres,Long> {

    //*! change 2

}
