package com.ra.session02.controller;

import com.ra.session02.model.entity.Employee;
import com.ra.session02.service.design.IDepartmentService;
import com.ra.session02.service.design.IEmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final IEmployeeService employeeService;
    private final IDepartmentService departmentService;
    @GetMapping("/list")
    public String list(Model model) {
        model.addAttribute("employees",employeeService.findAll());
        return "employee/list";
    }
    @GetMapping("/add")
    public String add(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("department",departmentService.getDepartments());
        return "employee/add";
    }
    @PostMapping("/add")
    public String doAdd(@ModelAttribute("employee") Employee employee, @RequestParam("departmentId") Integer departmentId) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable Integer id, Model model) {
        model.addAttribute("department",departmentService.getDepartments());
        model.addAttribute("employee", employeeService.findById(id));
        return "employee/edit";
    }
    @PostMapping("/edit")
    public String doEdit(@ModelAttribute Employee employee, @RequestParam("departmentId") Integer departmentId) {
        employee.setDepartment(departmentService.getDepartmentById(departmentId));
        employeeService.save(employee);
        return "redirect:/employee/list";
    }
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        employeeService.deleteById(id);
        return "redirect:/employee/list";
    }
}
