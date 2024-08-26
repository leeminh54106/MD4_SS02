package com.ra.session02.controller;

import com.ra.session02.model.entity.Student;
import com.ra.session02.repository.design.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Iterator;

@Controller
public class StudentController {
    @Autowired
    private IStudentRepo studentRepo;
    @RequestMapping
    public String test(Model model) {
        Iterable<Student> students = studentRepo.findAll();
        Iterator<Student> iterator = students.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        model.addAttribute("students", students);
        return "home";
    }
}
