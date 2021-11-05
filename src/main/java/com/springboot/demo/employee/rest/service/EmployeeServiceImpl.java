package com.springboot.demo.employee.rest.service;

import com.springboot.demo.employee.dao.EmployeeDAO;
import com.springboot.demo.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    EmployeeDAO employeeDAO;

    @Override
    @Transactional
    public List<Employee> getAll() {
        return employeeDAO.findAll();
    }

    @Override
    @Transactional
    public Employee getEmployee(int id) {
        Optional<Employee> opt = employeeDAO.findById(id);
        Employee emp = null;

        if (opt.isPresent()) {
            emp = opt.get();
        }
        return emp;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    @Override
    @Transactional
    public void delete(int id) {
        employeeDAO.deleteById(id);
    }
}