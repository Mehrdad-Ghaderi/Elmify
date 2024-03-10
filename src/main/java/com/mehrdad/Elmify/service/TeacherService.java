package com.mehrdad.Elmify.service;

import com.mehrdad.Elmify.entity.Teacher;
import com.mehrdad.Elmify.repository.TeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TeacherService {
    @Autowired
    TeacherRepository teacherRepository;

    public Optional<Teacher> getTeacherByID(String id) {
        return teacherRepository.findById(id);
    }

    public void save(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public List<Teacher> findAll() {
        return teacherRepository.findAll();
    }

}
