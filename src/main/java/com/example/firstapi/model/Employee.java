package com.example.firstapi.model;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name = "surname")
    private String surname;
    @Column(name = "email")
    private String email;
//    @Column(name = "isActive")
//    private boolean isActive;
}
