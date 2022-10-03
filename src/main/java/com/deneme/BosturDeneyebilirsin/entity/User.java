package com.deneme.BosturDeneyebilirsin.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "UserTable")
@Data
public class User {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "userId", nullable = false)
    private Long userId;

    @OneToOne(cascade=CascadeType.PERSIST)
    @JoinColumn(name="book_id",referencedColumnName = "bookId")
    private Book book;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm:ss", timezone="Germany")
    @Column(name="createdDate", nullable = true)
    private Date createdDate;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "adress")
    private String adress;

    @Column(name = "email")
    private String email;

    @Column(name = "mobilePhoneNumber")
    private String mobilePhoneNumber;

    @Column(name = "securityNumber")
    private String securityNumber;

    @Column(name = "isSingle")
    private boolean isSingle;

}
