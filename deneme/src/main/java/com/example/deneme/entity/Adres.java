package com.example.deneme.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "adreses")
public class Adres {

   @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   private String Sokak;

   private String Zip;

   private String Sehir;

   private String Ulke;


}
