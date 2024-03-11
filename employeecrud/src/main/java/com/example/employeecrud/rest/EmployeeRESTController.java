package com.example.employeecrud.rest;

import com.example.employeecrud.dao.EmployeeDAO;
import com.example.employeecrud.entity.Employee;
import com.example.employeecrud.service.EmployeeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRESTController {

    private EmployeeService employeeService;

    public EmployeeRESTController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeService.findAll();
    }

    @GetMapping("/employees/{id}")
    public Employee findById(@PathVariable int id) {

        Employee employee = employeeService.findById(id);

        if (employee == null) {
            throw new RuntimeException("employee not found");
        }

        return employee;
    }

    @PostMapping("/employees")
    public Employee addEmployee(@RequestBody Employee employee){

        employee.setId(0);

        Employee addedEmployee = employeeService.save(employee);

        return addedEmployee;
    }

    @PutMapping("employees")
    public Employee updateEmployee(@RequestBody Employee employee){

        Employee updatedEmployee = employeeService.save(employee);

        return updatedEmployee;
    }

    @DeleteMapping("employees/{id}")
    public String deleteEmployee(@PathVariable int id){

        Employee employee = employeeService.findById(id);

        if (employee==null){
            throw new RuntimeException("employee not found in the database");
        }

        employeeService.deleteById(id);

        return "Deleted employee with id = " + id;
    }
}
