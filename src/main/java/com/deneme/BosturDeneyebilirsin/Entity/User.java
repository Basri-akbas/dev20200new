package com.deneme.BosturDeneyebilirsin.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "abc")
public class User {

    @Id
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "isim")
    private String name;
    @Column(name = "soyIsim")
    private String soyIsim;
    @Column(name = "adres")
    private String adres;
    @Column(name = "telefon")
    private int telefon;



}
