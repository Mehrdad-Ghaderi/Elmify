package com.mehrdad.Elmify.controller;

import com.mehrdad.Elmify.entity.Teacher;
import com.mehrdad.Elmify.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@RequestMapping("/teachers")
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/list")
    public String showTeachers(Model model) {
        var teacherList = teacherService.findAll();
        model.addAttribute("teacherList", teacherList);
        return "teachers/teachers-list";
    }

    @GetMapping("/new")
    public String displayTeacherForm(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/create/new";
    }

    @PostMapping("/create")
    public String createTeacher(Teacher teacher, Model model) {
        var teacherByID = teacherService.getTeacherByID(teacher.getId());
        if (teacherByID.isPresent()) {
            return "teachers/create/failed";
        }
        teacherService.save(teacher);
        return "teachers/create/successful";
    }

    @GetMapping("/login")
    public String showLogin(Model model) {
        model.addAttribute("teacher", new Teacher());
        return "teachers/login/login";
    }

    @PostMapping("/authenticate")
    public String authenticate(Teacher teacher, Model model) {
        var teacherByID = teacherService.getTeacherByID(teacher.getId());
        if (teacherByID.isPresent()) {
            var foundTeacher = teacherByID.get();
            if (foundTeacher.getId().equals(teacher.getId())
                    && foundTeacher.getPassword().equals(teacher.getPassword())) {
                return "teachers/login/successful";
            } else {
                return "teachers/login/failed";
            }
        }
        return "teachers/login/not-found";
    }
}
