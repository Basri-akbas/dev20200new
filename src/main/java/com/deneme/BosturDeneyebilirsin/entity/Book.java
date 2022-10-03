package com.deneme.BosturDeneyebilirsin.entity;

import com.deneme.BosturDeneyebilirsin.entity.User;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Book")
public class Book {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "bookId", nullable = false)
    private Long bookId;

    @OneToOne(mappedBy = "book")
    private User user;

    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy/MM/dd HH:mm:ss", timezone="Germany")
    @Column(name="publishDate", nullable = false)
    private LocalDateTime publishDate;

    @Column(name = "bookName")
    private String bookName;

    @Column(name = "writer")
    private String writer;

    @Column(name = "bookVersion")
    private String bookVersion;

    @Column(name = "bookPageCount")
    private int bookPageCount;

    @Column(name = "isEpubVersionExist")
    private boolean isEpubVersionExist;

    public Book(long bookId, String title, String writer, Date time, String s, String version, boolean b) {
    }
}
