package com.example.employeecrud.dao;

import com.example.employeecrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();
}

