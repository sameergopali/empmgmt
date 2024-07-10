package com.itsura.employeemanagement.dao;

import com.itsura.employeemanagement.model.Department;
import lombok.extern.java.Log;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDAO extends JpaRepository<Department, Long> {

}

