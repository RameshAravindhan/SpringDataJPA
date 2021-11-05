package com.springboot.demo.employee.dao;

import com.springboot.demo.employee.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeDAO extends JpaRepository<Employee, Integer> {

}