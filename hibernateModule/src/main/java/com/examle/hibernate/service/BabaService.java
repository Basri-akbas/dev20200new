package com.examle.hibernate.service;

import com.examle.hibernate.repository.BabaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BabaService {

    @Autowired
    private BabaRepository babaRepository;

    public BabaService(BabaRepository babaRepository) {
        this.babaRepository = babaRepository;
    }

}
