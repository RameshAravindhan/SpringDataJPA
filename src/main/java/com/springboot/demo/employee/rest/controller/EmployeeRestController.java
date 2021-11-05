package com.springboot.demo.employee.rest.controller;

import com.springboot.demo.employee.entity.Employee;
import com.springboot.demo.employee.rest.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;


    @GetMapping(path = "/employees", produces = {MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE})
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


    @GetMapping("/asynctest")
    public String asyncOperation() throws InterruptedException {

        Thread.currentThread().setName("NORMAL THREAD");

        employeeService.printThread();


        return "Current Thread Name is:" + Thread.currentThread().getName();

    }

}