package com.studentProject.studentProject.controller;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.studentProject.studentProject.config.AppProperties;
import com.studentProject.studentProject.dto.StudentRequest;
import com.studentProject.studentProject.dto.StudentResponse;
import com.studentProject.studentProject.model.Student;
import com.studentProject.studentProject.service.AppInfoService;
import com.studentProject.studentProject.service.StudentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/students")
public class StudentController {
    private final StudentService studentService;
    private final AppProperties appProperties;

    public StudentController(StudentService studentService, AppProperties appProperties) {
        this.studentService = studentService;
        this.appProperties = appProperties;
    }

    // createStudent
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public StudentResponse createStudent(@Valid @RequestBody StudentRequest studentRequest) {
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setAge(studentRequest.getAge());
        return StudentResponse.fromEntity(studentService.createStudent(student));
        
    }

    // testMapping
    @GetMapping("/check-profile")
    @ResponseStatus(HttpStatus.OK)
    public String testFeatureX() {
        if(appProperties.isEnableFeatureX()) {
            return "Yes it is  dev";
        } else {
            return "Yes it is prod";
         }
    }

    

    // get all student
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getAllStudent() {
        return studentService.getAllStudent().stream().map(StudentResponse::fromEntity).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse getStudentById(@PathVariable Long id) {
        return StudentResponse.fromEntity(studentService.getStudentById(id));
    }

    @GetMapping("/search")
    @ResponseStatus(HttpStatus.OK)
    public List<StudentResponse> getStudentBysearch(@RequestParam(required = false) String name, @RequestParam(required = false) String email, @RequestParam(required = false) Integer age) {
        return studentService.getStudentBySearch(name, email, age).stream().map(StudentResponse::fromEntity).collect(Collectors.toList());
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public StudentResponse updateStudent(@PathVariable Long id, @Valid @RequestBody StudentRequest studentRequest) {
        // Convert DTO to entity
        Student student = new Student();
        student.setName(studentRequest.getName());
        student.setEmail(studentRequest.getEmail());
        student.setAge(studentRequest.getAge());
    
        // Call service
        Student updatedStudent = studentService.updateStudentById(id, student);
    
        // Convert entity to response DTO
        return StudentResponse.fromEntity(updatedStudent);
    }



    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteStudentById(@PathVariable Long id) {
        studentService.deleteStudentById(id);
    }


}
