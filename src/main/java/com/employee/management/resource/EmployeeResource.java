package com.employee.management.resource;


import com.employee.management.model.Employee;
import com.employee.management.security.jwt.JwtUtils;
import com.employee.management.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/employee")
public class EmployeeResource {
    private static final Logger logger = LoggerFactory.getLogger(JwtUtils.class);
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Employee>> getAllEmployees () {
        List<Employee> employees = employeeService.findAllEmployees();
        return new ResponseEntity<>(employees, HttpStatus.OK);
    }

    @GetMapping("/find/{idEmploye}")
    public ResponseEntity<Employee> getEmployeeByIdEmployee (@PathVariable("idEmploye") Long idEmploye) {
        Employee employee = employeeService.findEmployeeByIdEmploye(idEmploye);
        return new ResponseEntity<>(employee, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee employee) {
        Employee newEmployee = employeeService.addEmployee(employee);
        return new ResponseEntity<>(newEmployee, HttpStatus.CREATED);
    }

    @PutMapping("/update")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee employee) {
        Employee updateEmployee = employeeService.updateEmployee(employee);
        return new ResponseEntity<>(updateEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{idEmploye}")
    public ResponseEntity<?> deleteEmployee(@PathVariable("idEmploye") Long idEmploye) {
        employeeService.deleteEmployee(idEmploye);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}



