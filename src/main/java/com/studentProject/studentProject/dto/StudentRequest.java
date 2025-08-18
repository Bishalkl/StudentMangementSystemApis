package com.studentProject.studentProject.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class StudentRequest {

    @NotBlank(message = "Name cannot be blank")
    private String name;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email cannot be blank")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 1, message = "Age must be at least 1")
    private int age;

    // constructor
    public StudentRequest() {}

    public StudentRequest(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }

    
    // getter 
    public String getName () { return name; }
    public String getEmail () { return email; }
    public int getAge() { return age; }

    // setter
    public void setName (String name) { this.name = name; }
    public void setEmail (String email) { this.email = email; }
    public void setAge (int age) { this.age = age; }
}
