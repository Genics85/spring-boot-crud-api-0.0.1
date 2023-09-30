package com.spring.bootlearn.controller;

import com.spring.bootlearn.model.Employee;
import com.spring.bootlearn.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

    EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        super();
        this.employeeService = employeeService;
    }
    @PostMapping()
    public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
        return new ResponseEntity<>(employeeService.saveEmployee(employee),HttpStatus.CREATED);
    }
    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity(employeeService.getAllEmployee(),HttpStatus.FOUND);
    }
    @GetMapping("/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long id){
        return new ResponseEntity(employeeService.getById(id),HttpStatus.FOUND);
    }
     @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable ("id") Long id){
        return new ResponseEntity(employeeService.delete(id),HttpStatus.OK);
     }
}
