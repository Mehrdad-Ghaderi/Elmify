package com.mehrdad.Elmify.service;

import com.mehrdad.Elmify.entity.Teacher;

import java.util.Optional;

public interface TeacherService {
    void saveTeacher(Teacher teacher);
    Optional<Teacher> findByUsername(String username);
}
