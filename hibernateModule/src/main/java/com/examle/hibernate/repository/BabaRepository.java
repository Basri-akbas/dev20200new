package com.examle.hibernate.repository;

import com.examle.hibernate.entity.Baba;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BabaRepository extends JpaRepository<Baba,Long> {
}
