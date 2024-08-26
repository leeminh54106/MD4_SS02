package com.ra.session02.service.impl;


import com.ra.session02.model.entity.Department;
import com.ra.session02.repository.design.IDepartmentRepo;
import com.ra.session02.service.design.IDepartmentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class DepartmentServiceImpl implements IDepartmentService {
    private final IDepartmentRepo departmentRepo;
    @Override
    public List<Department> getDepartments() {
        return departmentRepo.findAll();
    }

    @Override
    public Department getDepartmentById(Integer id) {
        return departmentRepo.findById(id).orElse(null);
    }

    @Override
     public void  saveDepartment(Department department) {
        departmentRepo.save(department);
    }

    @Override
    public void deleteDepartment(Integer id) {
        departmentRepo.deleteById(id);
    }
}
