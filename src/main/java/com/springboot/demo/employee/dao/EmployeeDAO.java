package com.springboot.demo.employee.dao;

import com.springboot.demo.employee.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    public List<Employee> findall();
    public Employee find(int id);
    public void save(Employee employee);
    public void delete(int id);
}