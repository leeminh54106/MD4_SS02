package com.ra.session02.service.design;

import com.ra.session02.model.entity.Employee;

import java.util.List;

public interface IEmployeeService {
    List<Employee> findAll();
    Employee findById(Integer id);
    void save(Employee employee);
    void deleteById(Integer id);
}
