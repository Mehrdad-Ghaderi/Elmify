package com.mehrdad.Elmify.service;

import com.mehrdad.Elmify.entity.Student;
import com.mehrdad.Elmify.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public void saveStudent(Student student) {
        studentRepository.save(student);
    }

    @Override
    public Optional<Student> findByUsername(String username) {
        return studentRepository.findByUsername(username);
    }
}

