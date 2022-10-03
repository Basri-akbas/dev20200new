package com.examle.hibernate.service;

import com.examle.hibernate.repository.AnneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AnneService {

    @Autowired
    private AnneRepository anneRepository;

    public AnneService(AnneRepository anneRepository) {
        this.anneRepository = anneRepository;
    }


}
