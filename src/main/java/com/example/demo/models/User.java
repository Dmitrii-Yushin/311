package com.example.demo.models;

import javax.persistence.*;
import javax.validation.constraints.*;


@Entity
@Table(name = "users")
@NamedQuery(name = "User.getAll", query = "select u from User u")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private long id;

    @Column(name="name")
    @NotEmpty(message = "Name should not be empty!")
    @Size(min = 2, max = 30, message = "Name should be between 2 and 30 characters!")
    private String name;

    @Column(name="age")
    @Min(value = 0, message = "Age should be greater than 0!")
    private int age;
    @Column(name="email")
    @NotEmpty(message = "Email should be not empty!")
    @Email(message = "Email should be valid!")
    private String email;

    public User(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public User() {}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}