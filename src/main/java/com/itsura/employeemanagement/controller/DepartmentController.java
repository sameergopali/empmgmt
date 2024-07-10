package com.itsura.employeemanagement.controller;

import com.itsura.employeemanagement.model.Department;
import com.itsura.employeemanagement.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;


@RestController
    @RequestMapping("/api/departments")
    public class DepartmentController {

        @Autowired
        private DepartmentService departmentService;

        // Get all departments
        @GetMapping
        public List<Department> getAllDepartments() {
            return departmentService.getAllDepartments();
        }

        // Get department by ID
        @GetMapping("/{id}")
        public ResponseEntity<Department> getDepartmentById(@PathVariable Long id) {
            Optional<Department> department = departmentService.getDepartmentById(id);
            return department.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Add new department
        @PostMapping
        public Department addDepartment(@RequestBody Department department) {
            return departmentService.addDepartment(department);
        }

        // Update department
        @PutMapping("/{id}")
        public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department departmentDetails) {
            Department updatedDepartment = departmentService.updateDepartment(id, departmentDetails);
            return ResponseEntity.ok(updatedDepartment);
        }

        // Delete department
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteDepartment(@PathVariable Long id) {
            departmentService.deleteDepartment(id);
            return ResponseEntity.noContent().build();
        }


    }
