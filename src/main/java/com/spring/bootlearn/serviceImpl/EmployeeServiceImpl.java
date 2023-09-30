package com.spring.bootlearn.serviceImpl;

import com.spring.bootlearn.exception.ResourceNotFound;
import com.spring.bootlearn.model.Employee;
import com.spring.bootlearn.repository.EmployeeRepository;
import com.spring.bootlearn.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {


    EmployeeRepository employeeRepository;
    @Autowired
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getById(Long id) {
        return employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Employee","id",id));
    }

    @Override
    public String delete(Long id) {
        employeeRepository.findById(id).orElseThrow(()-> new ResourceNotFound("Employee","id",id));
        employeeRepository.deleteById(id);
        return "Deleted";
    }
}
