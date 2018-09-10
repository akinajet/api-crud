package com.innovetive.innovetivetest.Controller;

import com.innovetive.innovetivetest.Exception.ResourceNotFoundException;
import com.innovetive.innovetivetest.Model.Employee;
import com.innovetive.innovetivetest.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    EmployeeRepository employeeRepository;

    //Get all Employees
    @GetMapping("/Employees")
    public List<Employee> getAllEmployees()
    {
        return employeeRepository.findAll();
    }

    //Create a new Employee
    @PostMapping("/Employees")
    public Employee createEmployee(@Valid @RequestBody Employee employee)
    {
        return employeeRepository.save(employee);
    }

    //Get a single Employee
    @GetMapping("/Employees/{id}")
    public Employee getEmployeeById (@PathVariable(value = "id") Long employeeId)
    {
        return employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));
    }

    //Update an Employee
    @PutMapping("/Employees/{id}")
    public Employee updateEmployee(@PathVariable(value = "id") Long employeeId,
                                   @Valid @RequestBody Employee employeeDetails)
    {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", employeeId));

        employee.setEmployeeName(employeeDetails.getEmployeeName());
        employee.setEmployeeAddress(employeeDetails.getEmployeeAddress());
        employee.setEmployeeEmail(employeeDetails.getEmployeeEmail());
        employee.setEmployeeGender(employeeDetails.getEmployeeGender());
        employee.setEmployeePhoneNumber(employeeDetails.getEmployeePhoneNumber());

        Employee updatedEmployee = employeeRepository.save(employee);
        return updatedEmployee;
    }

    //Delete an Employee
}
