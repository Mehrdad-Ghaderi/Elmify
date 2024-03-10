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
        /*Student student = new Student();
        student.setId("2");
        student.setFirstName("sevil");
        student.setLastName("Basser");
        student.setEmail("sevil@gmail.com");
        student.setPhoneNumber("09121111111");
        student.setUsername("sevils");
        student.setPassword("bassers");
        studentService.save(student);*/
        var studentList = studentService.findAll();

        model.addAttribute("studentList", studentList);
        return "students/students-list";
    }

    @GetMapping("/sign-in")
    public String showLogin(Model model) {

        return "students/sign-in/sign-in";
    }

    @GetMapping("/new")
    public String displayStudentForm(Model model) {
        model.addAttribute("student", new Student());
        return "students/new-student";
    }

    @PostMapping("/create")
    public String createStudent(Student student, Model model) {
        studentService.save(student);
        /*var studentByID = studentService.getStudentByID(student.getId());
        if (studentByID.isPresent()) {
            return "common/failed-submission";
        }*/
        return "redirect:/students/list";
    }
}
