package com.springboot.demo.employee.rest.service;

import com.springboot.demo.employee.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> getAll();

    Employee getEmployee(int id);

    public void save(Employee employee);

    void delete(int id);

    void printThread() throws InterruptedException;



}