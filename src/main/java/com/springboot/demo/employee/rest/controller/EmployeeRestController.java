package com.springboot.demo.employee.rest.controller;

import com.springboot.demo.employee.entity.Employee;
import com.springboot.demo.employee.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping("/employees")
    public List<Employee> getEmployees() {
        return employeeService.getAll();
    }


    @GetMapping("/employees/{employeeID}")
    public Employee getEmployee(@PathVariable int employeeID) {
        return employeeService.getEmployee(employeeID);
    }


    @PostMapping("/employee")
    public void addEmployee(@RequestBody Employee employee) {
      //  employee.setId(0);
        employeeService.save(employee);

    }

    @DeleteMapping("/employees/{employeeID}")
    public void deleteEmployee(@PathVariable int employeeID) {
        employeeService.delete(employeeID);
    }


}