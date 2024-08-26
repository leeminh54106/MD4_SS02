package com.ra.session02.service.impl;

import com.ra.session02.model.entity.Employee;
import com.ra.session02.repository.design.IEmployeeRepo;
import com.ra.session02.service.design.IEmployeeService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Transactional
public class EmployeeService implements IEmployeeService {
    private final IEmployeeRepo employeeRepo;
    @Override
    public List<Employee> findAll() {
        return employeeRepo.findAll();
    }

    @Override
    public Employee findById(Integer id) {
        return employeeRepo.findById(id).orElse(null);
    }

    @Override
    public void save(Employee employee) {
        employeeRepo.save(employee);
    }

    @Override
    public void deleteById(Integer id) {
        employeeRepo.deleteById(id);
    }
}
