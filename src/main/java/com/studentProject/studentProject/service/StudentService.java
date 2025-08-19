package com.studentProject.studentProject.service;


import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.stereotype.Service;
import com.studentProject.studentProject.model.Student;
import com.studentProject.studentProject.repository.StudentRepository;


@Service
public class StudentService {
    private final StudentRepository studentRepository;


    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    // first create 
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    // getAllStudent
    public List<Student> getAllStudent() {
        return studentRepository.findAll(); // return empty list if none
    }

    // getById
    public Student getStudentById(Long id) {
        Student student = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student with id " + id + "not found"));
        return student;
        
    }

    // getBysearch
    public List<Student> getStudentBySearch(String name ,String email, int age) {
        List<Student> result = studentRepository.searchStudents(name != null ? name.toLowerCase() : null,
                                                                email != null ? email.toLowerCase(): null,
                                                                age);
        if(result.isEmpty()) throw new NoSuchElementException("Student are not found at search critera");
        return result;
    }

    public Student updateStudentById(Long id, Student request) {
        // Fetch existing student
        Student existingStudent = studentRepository.findById(id)
            .orElseThrow(() -> new NoSuchElementException("Student with id " + id + " not found"));
    
        // Update fields
        existingStudent.setName(request.getName());
        existingStudent.setEmail(request.getEmail());
        existingStudent.setAge(request.getAge());
    
        // Save and return
        return studentRepository.save(existingStudent);
    }
    
    

    // deleteById
    public void deleteStudentById(Long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(() -> new NoSuchElementException("Student with id " + id + "not found"));
        studentRepository.delete(existingStudent);
    }
}
