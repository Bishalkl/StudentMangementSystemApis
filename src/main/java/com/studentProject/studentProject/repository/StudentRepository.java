package com.studentProject.studentProject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.studentProject.studentProject.model.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

    @Query("SELECT s FROM Student s WHERE " +
       "(:name IS NULL OR LOWER(s.name) LIKE LOWER(CONCAT('%', :name, '%'))) AND " +
       "(:email IS NULL OR LOWER(s.email) LIKE LOWER(CONCAT('%', :email, '%'))) AND " +
       "(:age IS NULL OR s.age = :age)")
        List<Student> searchStudents(@Param("name") String name,
                                     @Param("email") String email,
                                     @Param("age") Integer age);
}