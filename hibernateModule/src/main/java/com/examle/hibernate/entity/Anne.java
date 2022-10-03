package com.examle.hibernate.entity;

import javax.persistence.*;

@Entity
@Table(name = "anne")
public class Anne {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String surname;

    private String age;

    private boolean retired;

    public Anne(Long id, String name, String surname, String age, boolean retired) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.age = age;
        this.retired = retired;
    }

    public Anne() {
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
}
