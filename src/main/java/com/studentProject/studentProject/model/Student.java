package com.studentProject.studentProject.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotBlank
    private String name;

    @Email
    @NotBlank
    private String email;

    @Min(18)
    private int age;


    // constructor
    public Student() {}

    public Student(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    

    // getter 
    public Long getId() {return id; }
    public String getName () { return name; }
    public String getEmail () { return email; }
    public int getAge() { return age; }

    // setter
    public void setName (String name) { this.name = name; }
    public void setEmail (String email) { this.email = email; }
    public void setAge (int age) { this.age = age; }
}
