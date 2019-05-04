package com.example.demo.dao;

import com.example.demo.entity.Department;

import java.util.List;

public interface DepartmentDAO {

    public List<Department> findAllDepartments();

    public Department findDepartmentById(int departmentId);

    public void save(Department theDepartment);

    public void deleteById(int theId);
}
