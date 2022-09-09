package com.deneme.BosturDeneyebilirsin.Entity;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Email;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    private Long id;

  /*  @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "book_id", referencedColumnName = "bookId")
    private User bookId;
*/
    @Column(name = "isim")
    private String name;

    @Column(name = "soyIsim")
    private String soyIsim;

    @Column(name = "adres")
    private String adres;

    @Column(name = "telefon")
    private String telefon;

    /* @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Turkey")
    @Column(name="date")
    private LocalDateTime createdDate;

    @Column(name="email")
    @Email
    private String email;

    @Column(name="securityNumber ")
    private String securityNumber ;

    @Column(name="single")
    private boolean isSingle;
*/

}
