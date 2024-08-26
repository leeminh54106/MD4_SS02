package com.ra.session02.controller;

import com.ra.session02.model.entity.Department;
import com.ra.session02.service.design.IDepartmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/department")
@RequiredArgsConstructor
public class DepartmentController {
    private final IDepartmentService departmentService;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("departments",departmentService.getDepartments());
        return "department/list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("department", new Department());
        return "department/add";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/department/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("department", departmentService.getDepartmentById(id));
        return "department/edit";
    }
    @PostMapping("/edit")
    public String doEdit(@ModelAttribute Department department) {
        departmentService.saveDepartment(department);
        return "redirect:/department/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        departmentService.deleteDepartment(id);
        return "redirect:/department/list";
    }
}
