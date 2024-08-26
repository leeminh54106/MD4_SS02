package com.ra.session02.repository.design;

import com.ra.session02.model.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;


public interface IEmployeeRepo extends JpaRepository<Employee, Integer> {
}
