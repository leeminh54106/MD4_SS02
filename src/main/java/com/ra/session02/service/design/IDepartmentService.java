package com.ra.session02.service.design;


import com.ra.session02.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDepartmentService {
    List<Department> getDepartments();
    Department getDepartmentById(Integer id);
    void saveDepartment(Department department);
    void deleteDepartment(Integer id);
}
