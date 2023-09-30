package com.spring.bootlearn.service;

import com.spring.bootlearn.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee saveEmployee(Employee employee);
    List<Employee> getAllEmployee();
    Employee getById(Long id);

    String delete(Long id);
}
