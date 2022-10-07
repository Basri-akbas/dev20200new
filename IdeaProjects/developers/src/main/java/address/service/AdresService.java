package address.service;

import com.github.javafaker.Faker;
import org.springframework.stereotype.Service;
import address.entity.Adres;
import address.repository.AdresRepository;

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
