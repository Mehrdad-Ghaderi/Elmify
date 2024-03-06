package com.mehrdad.Elmify.service;

import com.mehrdad.Elmify.entity.Teacher;
import com.mehrdad.Elmify.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TeacherServiceImpl implements TeacherService {

    @Autowired
    private TeacherRepository teacherRepository;

    @Override
    public void saveTeacher(Teacher teacher) {

    }

    @Override
    public Optional<Teacher> findByUsername(String username) {
        return Optional.empty();
    }
}
