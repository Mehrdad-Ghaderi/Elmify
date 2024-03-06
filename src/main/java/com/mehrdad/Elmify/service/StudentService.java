package com.mehrdad.Elmify.service;

import com.mehrdad.Elmify.entity.Student;

import java.util.Optional;

public interface StudentService {

    void saveStudent(Student student);

    Optional<Student> findByUsername(String username);
}
