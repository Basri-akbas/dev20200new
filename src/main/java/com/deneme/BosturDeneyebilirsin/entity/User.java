package com.deneme.BosturDeneyebilirsin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book bookId;

    @Column(name = "isim")
    private String name;

    @Column(name = "soyIsim")
    private String soyIsim;

    @Column(name = "adres")
    private String adres;

    @Column(name = "telefon")
    private String telefon;

     @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Turkey")
    @Column(name="date")
    private Date createdDate;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="securityNumber ")
    private String securityNumber ;

    @Column(name="single")
    private boolean isSingle;


}
