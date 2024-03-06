package com.mehrdad.Elmify.service;

import com.mehrdad.Elmify.entity.Student;
import com.mehrdad.Elmify.entity.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

// UserDetailsServiceImpl.java
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final StudentService studentService;
    private final TeacherService teacherService;

    @Autowired
    public UserDetailsServiceImpl(StudentService studentService, TeacherService teacherService) {
        this.studentService = studentService;
        this.teacherService = teacherService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Student> student = studentService.findByUsername(username);
        Optional<Teacher> teacher = teacherService.findByUsername(username);

        if (student.isPresent()) {
            return new CustomUserDetails(student.get());
        } else if (teacher.isPresent()) {
            return new CustomUserDetails(teacher.get());
        } else {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }
    }
}

