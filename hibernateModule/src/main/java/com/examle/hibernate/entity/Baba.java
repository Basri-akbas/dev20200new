package com.examle.hibernate.entity;


import javax.persistence.*;

@Entity
@Table(name = "baba")
public class Baba {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String age;

    private boolean retired;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "anne_id", referencedColumnName = "id")
    private Anne anneId;

    public Baba() {
    }

    public Baba(Long id, String name, String surname, String age, boolean retired, Anne anneId) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.retired = retired;
        this.anneId = anneId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public boolean isRetired() {
        return retired;
    }

    public void setRetired(boolean retired) {
        this.retired = retired;
    }

    public Anne getAnneId() {
        return anneId;
    }

    public void setAnneId(Anne anneId) {
        this.anneId = anneId;
    }
}
