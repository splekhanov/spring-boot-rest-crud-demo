package com.example.demo.rest;

import com.example.demo.entity.Department;
import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class DepartmentRestController {

    @Autowired
    private DepartmentService departmentService;

    @GetMapping("/departments")
    public ResponseEntity<List<Department>> findAllDepartments() {
        return new ResponseEntity<List<Department>>(departmentService.findAllDepartments(), HttpStatus.OK);
    }

    @GetMapping("/departments/{departmentId}")
    public ResponseEntity<Department> findDepartmentById(@PathVariable int departmentId) throws EmployeeServiceException {
        Department theDepartment = departmentService.findDepartmentById(departmentId);
        if (theDepartment == null || theDepartment.getId() <= 0) {
            throw new EmployeeServiceException("Department with id " + departmentId + " does not exist");
        }
        return new ResponseEntity<Department>(theDepartment, HttpStatus.OK);
    }
}
