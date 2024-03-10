package com.mehrdad.Elmify.repository;

import com.mehrdad.Elmify.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StudentRepository extends JpaRepository<Student, String> {

}
