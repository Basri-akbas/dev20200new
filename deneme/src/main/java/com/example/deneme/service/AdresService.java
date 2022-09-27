package com.example.deneme.service;

import com.example.deneme.entity.Adres;
import com.example.deneme.repository.AdresRepository;
import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;

@Service
public class AdresService {

    private final AdresRepository adresRepository;

    public AdresService(AdresRepository adresRepository) {
        this.adresRepository = adresRepository;
    }


    public void addAdres(){
        Faker faker=new Faker();

        for (int i=0;i<10;i++){
            long id=faker.number().randomNumber();
            String sokak=faker.address().streetName();
            String zip=faker.address().zipCode();
            String sehir=faker.address().city();
            String ulke=faker.address().country();

            Adres adres=new Adres(id,sokak,zip,sehir,ulke);
            adresRepository.save(adres);
        }

    }
}
