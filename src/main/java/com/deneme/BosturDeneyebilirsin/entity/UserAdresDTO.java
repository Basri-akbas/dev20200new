package com.deneme.BosturDeneyebilirsin.entity;

import com.example.deneme.entity.Adres;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserAdresDTO {

   private Long id;

    private String name;

    private String soyIsim;

    private String adres;

    private String telefon;

    private String email;

    private String securityNumber ;

    private boolean isSingle;


    private Long bookId;

    private AdresDTO  adresId;


}
