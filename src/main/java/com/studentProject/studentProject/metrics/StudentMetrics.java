package com.studentProject.studentProject.metrics;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.studentProject.studentProject.repository.StudentRepository;

import io.micrometer.core.instrument.MeterRegistry;

@Component
public class StudentMetrics {

    private StudentRepository studentRepository;
    private final MeterRegistry registry;

    @Autowired
    public StudentMetrics(StudentRepository studentRepository, MeterRegistry registry) {
        this.studentRepository = studentRepository;
        this.registry = registry;
        // register the gauge for student count
        registry.gauge("student.count", this, StudentMetrics::getStudentCount);
    }


    // Replace with actual DB/repo count later
    public int getStudentCount() {
        return (int) studentRepository.count();
    }
}
