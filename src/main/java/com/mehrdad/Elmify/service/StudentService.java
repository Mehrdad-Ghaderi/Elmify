package com.mehrdad.Elmify.service;

import com.mehrdad.Elmify.entity.Student;
import com.mehrdad.Elmify.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    public Optional<Student> getStudentByID(String id) {
        return studentRepository.findById(id);
    }

    public void save(Student student) {
        studentRepository.save(student);
    }

    public List<Student> findAll() {
        return studentRepository.findAll();
    }

}
