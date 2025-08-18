1️⃣ Project Documentation (Technical Overview)
Project Name:

Student Management System API

Technologies Used:

Backend: Spring Boot

Database: H2 (In-memory)

Build Tool: Maven

Validation: Jakarta Bean Validation (@NotBlank, @Email, @NotNull)

Other Tools: Spring Data JPA, DTOs, Custom Queries

Features:

CRUD Operations:

Create Student: Add a new student record.

Read Students: Fetch all students or a single student by ID.

Update Student: Full update of student data by ID.

Delete Student: Remove a student by ID.

Search Functionality:

Search students by name, email, or age using a custom JPA query.

Supports optional query parameters.

DTOs and Validation:

StudentRequest for incoming requests

StudentResponse for API responses

Validation ensures name and email are not blank, email format is correct, and age is valid.

Exception Handling:

Throws NoSuchElementException for missing student records.

Validation errors handled by Spring’s @Valid.

Database:

H2 in-memory database for fast development and testing.

H2 console enabled for easy inspection.

Sample API Endpoints:
HTTP Method Endpoint Description
POST /api/students Create a new student
GET /api/students Get all students
GET /api/students/{id} Get student by ID
GET /api/students/search Search students (name, email, age)
PUT /api/students/{id} Update student by ID
DELETE /api/students/{id} Delete student by ID
Learnings from the Project:

Learned Spring Boot core concepts: controllers, services, repositories.

Hands-on experience with DTO mapping and validation.

Created custom search queries using @Query in Spring Data JPA.

Worked with H2 in-memory database and configured it via application.properties.

Understood RESTful API design and proper HTTP status codes.
