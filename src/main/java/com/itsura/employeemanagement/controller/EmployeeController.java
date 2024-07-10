package com.itsura.employeemanagement.controller;



import com.itsura.employeemanagement.model.Employee;
import com.itsura.employeemanagement.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

    @RestController
    @RequestMapping("/api/employees")
    public class EmployeeController {

        @Autowired
        private EmployeeService employeeService;

        // Get all employees
        @GetMapping
        public List<Employee> getAllEmployees() {
            return employeeService.getAllEmployees();
        }

        // Get employee by ID
        @GetMapping("/{id}")
        public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id) {
            Optional<Employee> employee = employeeService.getEmployeeById(id);
            return employee.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Add new employee
        @PostMapping
        public Employee addEmployee(@RequestBody Employee employee) {
            return employeeService.addEmployee(employee);
        }

        // Update employee
        @PutMapping("/{id}")
        public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee employeeDetails) {
            Employee updatedEmployee = employeeService.updateEmployee(id, employeeDetails);
            return ResponseEntity.ok(updatedEmployee);
        }

        // Delete employee
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteEmployee(@PathVariable Long id) {
            employeeService.deleteEmployee(id);
            return ResponseEntity.noContent().build();
        }
    }


