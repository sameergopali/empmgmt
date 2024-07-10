package com.itsura.employeemanagement.controller;

import com.itsura.employeemanagement.model.Role;
import com.itsura.employeemanagement.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;



@RestController
@RequestMapping("/api/roles")
public class RoleController {

        @Autowired
        private RoleService roleService;

        // Get all roles
        @GetMapping
        public List<Role> getAllRoles() {
            return roleService.getAllRoles();
        }

        // Get role by ID
        @GetMapping("/{id}")
        public ResponseEntity<Role> getRoleById(@PathVariable Long id) {
            Optional<Role> role = roleService.getRoleById(id);
            return role.map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
        }

        // Add new role
        @PostMapping
        public Role addRole(@RequestBody Role role) {
            return roleService.addRole(role);
        }

        // Update role
        @PutMapping("/{id}")
        public ResponseEntity<Role> updateRole(@PathVariable Long id, @RequestBody Role roleDetails) {
            Role updatedRole = roleService.updateRole(id, roleDetails);
            return ResponseEntity.ok(updatedRole);
        }

        // Delete role
        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteRole(@PathVariable Long id) {
            roleService.deleteRole(id);
            return ResponseEntity.noContent().build();
        }
}

