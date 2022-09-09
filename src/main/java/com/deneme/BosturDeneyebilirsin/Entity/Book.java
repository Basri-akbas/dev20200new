package com.deneme.BosturDeneyebilirsin.Entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "book_id", nullable = false)
    private Long bookId;



    @Column(name = "writer")
    private String writer;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy/MM/dd HH:mm:ss", timezone = "Turkey")
    @Column(name = "publishDate")
    private LocalDateTime publishDate;

    @Column(name = "pageCount")
    private String pageCount;

    @Column(name = "version")
    private String version;

    @Column(name = "isEpubVersionExist")
    private boolean isEpubVersionExist;
}
