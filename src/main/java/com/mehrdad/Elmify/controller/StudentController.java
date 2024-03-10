package com.mehrdad.Elmify.controller;

import com.mehrdad.Elmify.entity.Student;
import com.mehrdad.Elmify.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/students")
public class StudentController {
    @Autowired
    StudentService studentService;

    @GetMapping("/list")
    public String showStudents(Model model) {
        var studentList = studentService.findAll();
        model.addAttribute("studentList", studentList);
        return "students/students-list";
    }

    @GetMapping("/new")
    public String displayStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/create/new";
    }

    @PostMapping("/create")
    public String createStudent(Student student, Model model) {
        var studentByID = studentService.getStudentByID(student.getId());
        if (studentByID.isPresent()) {
            return "students/create/failed";
        }
        studentService.save(student);
        return "students/create/successful";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("student", new Student());
        return "students/login/login";
    }

    @PostMapping("/authenticate")
    public String authenticate(Student student, Model model) {
        var studentByID = studentService.getStudentByID(student.getId());
        if (studentByID.isPresent()) {
            var foundStudent = studentByID.get();
            if (foundStudent.getId().equals(student.getId())
                    && foundStudent.getPassword().equals(student.getPassword())) {
                return "students/login/successful";
            } else {
                return "students/login/failed";
            }
        }
        return "students/login/not-found";
    }
}
