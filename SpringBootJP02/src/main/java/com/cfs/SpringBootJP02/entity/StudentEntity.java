package com.cfs.SpringBootJP02.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// @Entity batata hai ki ye class DB table se map hogi
@Entity
public class StudentEntity {

    // @Id = Primary Key
    // @GeneratedValue = Auto Increment (MySQL)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Simple columns
    private String name;
    private String email;

    public StudentEntity() {}

    public StudentEntity(String name, String email) {
        this.name = name;
        this.email = email;
    }

    //Getters & Setters (Hibernate inka use karta hai)
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }


}
