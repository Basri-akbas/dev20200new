package com.examle.hibernate.repository;

import com.examle.hibernate.entity.Anne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnneRepository extends JpaRepository<Anne,Long> {
}
