package com.mehrdad.Elmify.repository;

import com.mehrdad.Elmify.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;


public interface StudentRepository extends JpaRepository<Student, String> {

}
