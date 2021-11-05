package com.springboot.demo.employee.rest.service;

import com.springboot.demo.employee.dao.EmployeeDAO;
import com.springboot.demo.employee.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
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

    @Override
    @Scheduled(fixedRate = 1000)
    @Async
    public void printThread() throws InterruptedException {
     //   Thread.currentThread().setName("ASYNC Thread");
        Thread.sleep(3000);
        System.out.println("NAME OF EXECUTING THREAD IS " + Thread.currentThread().getName());
        System.out.println(
                "Fixed rate task - " + System.currentTimeMillis() / 1000);
    }
}