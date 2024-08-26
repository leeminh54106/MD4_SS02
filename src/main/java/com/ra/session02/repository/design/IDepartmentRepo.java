package com.ra.session02.repository.design;

import com.ra.session02.model.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDepartmentRepo extends JpaRepository<Department, Integer> {
}
