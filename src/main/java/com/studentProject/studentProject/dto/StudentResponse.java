package com.studentProject.studentProject.dto;

import com.studentProject.studentProject.model.Student;

public class StudentResponse {
    private Long id;
    private String name;
    private String email;
    private int age;

    public StudentResponse(Long id, String name, String email, int age) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.age = age;
    }

    // getter and setter\
    // getter 
    public Long getId () { return id; }
    public String getName () { return name; }
    public String getEmail () { return email; }
    public int getAge() { return age; }

    // setter
    public void setID (Long id) { this.id = id; }
    public void setName (String name) { this.name = name; }
    public void setEmail (String email) { this.email = email; }
    public void setAge (int age) { this.age = age; }


    public static StudentResponse fromEntity(Student student) {
        return new StudentResponse(student.getId(), student.getName(), student.getEmail(), student.getAge());
    }
}
