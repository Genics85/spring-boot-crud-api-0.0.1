package com.spring.bootlearn.serviceImpl;

import com.spring.bootlearn.model.Employee;
import com.spring.bootlearn.repository.EmployeeRepository;
import com.spring.bootlearn.service.EmployeeService;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }
}
