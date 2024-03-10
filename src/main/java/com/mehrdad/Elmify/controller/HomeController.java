package com.mehrdad.Elmify.controller;

import com.mehrdad.Elmify.entity.Student;
import com.mehrdad.Elmify.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@RequestMapping("/home")
public class HomeController {

    @Autowired
    private StudentService studentService;

    @GetMapping
    public String showHome(Model model) {
        return "main/home";
    }
}
