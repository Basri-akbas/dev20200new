package com.deneme.BosturDeneyebilirsin.repository;

import com.deneme.BosturDeneyebilirsin.entity.User;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.HttpClientErrorException;

import java.util.List;
@Qualifier("users")
@Repository
@Transactional
public interface UserRepository extends JpaRepository<User, Long>{


    @Modifying
    @Query("UPDATE User u " +
            "SET u.name = ?2, u.soyIsim = ?3, u.adres= ?4, u.telefon = ?5" +
            "WHERE u.id = ?1")
    void update(Long id, String name, String soyIsim, String adres, String telefon) throws HttpClientErrorException.BadRequest;

    List<User> findAllBy();


}
