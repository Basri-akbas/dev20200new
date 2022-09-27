package com.deneme.BosturDeneyebilirsin.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   // @OneToOne(cascade = CascadeType.PERSIST)
    //@JoinColumn(name = "user_id", referencedColumnName = "id")
    //private User userId;

    @Column(name = "title")
    private String title;

    @Column(name = "writer")
    private String writer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Turkey")
    @Column(name = "publishDate")
    private Date publishDate;

    @Column(name = "pageCount")
    private String pageCount;

    @Column(name = "version")
    private String version;

    @Column(name = "isEpubVersionExist")
    private boolean isEpubVersionExist;


}
