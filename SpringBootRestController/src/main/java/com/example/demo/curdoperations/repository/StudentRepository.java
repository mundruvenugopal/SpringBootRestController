package com.example.demo.curdoperations.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.curdoperations.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByEmail(String email);

    boolean existsByFirstName(String firstName);

    boolean existsByLastName(String lastName);

    List<Student> findAllByOrderByIdAsc();

    // JPQL Query to update a student's details
    @Transactional
    @Modifying
    @Query("UPDATE Student s SET s.firstName = :firstName, s.lastName = :lastName, s.email = :email, s.phNo = :phNo WHERE s.id = :id")
    int updateStudent(@Param("id") Long id,
                      @Param("firstName") String firstName,
                      @Param("lastName") String lastName,
                      @Param("email") String email,
                      @Param("phNo") String phNo);

    // JPQL Query to delete a student by ID
    @Transactional
    @Modifying
    @Query("DELETE FROM Student s WHERE s.id = :id")
    int deleteStudentById(@Param("id") Long id);

    // JPQL Query to find a student by ID for reading purposes.
    @Query("SELECT s FROM Student s WHERE s.id = :id")
    Student findStudentById(@Param("id") Long id);
}