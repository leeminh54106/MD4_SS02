package com.ra.session02.api;

import com.ra.session02.model.entity.Department;
import com.ra.session02.repository.design.IDepartmentRepo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api.example.com/departments")
public class DepartmentApiController {
    @Autowired
    private IDepartmentRepo departmentRepo;
    // tra ve danh sach phong ban
    @GetMapping
    public ResponseEntity<List<Department>> getAllDepartments() {
        return new ResponseEntity<>(departmentRepo.findAll(), HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable Integer id) {
        Department department =departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        return new ResponseEntity<>(department, HttpStatus.OK);
    }
    @PostMapping
    public ResponseEntity<Department> doAdd(@RequestBody Department department) {
        Department d = departmentRepo.save(department);
        return ResponseEntity.ok(d);
    }
    @PutMapping("/{id}")
    public ResponseEntity<Department> doUpdate(@RequestBody Department department, @PathVariable Integer id) {
        departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        department.setId(id);
        Department d = departmentRepo.save(department);
        return ResponseEntity.ok(d);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> doDelete(@PathVariable Integer id) {
        departmentRepo.findById(id).orElseThrow(() -> new RuntimeException("id not found"));
        departmentRepo.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
