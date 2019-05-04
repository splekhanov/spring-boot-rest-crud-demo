package com.example.demo.service;

import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentService {

    public List<Department> findAllDepartments();

    public Department findDepartmentById(int departmentId);
}
