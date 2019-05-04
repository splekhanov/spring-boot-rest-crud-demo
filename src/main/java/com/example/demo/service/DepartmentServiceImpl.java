package com.example.demo.service;

import com.example.demo.dao.DepartmentDAO;
import com.example.demo.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    @Transactional
    public List<Department> findAllDepartments() {
        return departmentDAO.findAllDepartments();
    }
    
    @Override
    @Transactional
    public Department findDepartmentById(int departmentId){
        return departmentDAO.findDepartmentById(departmentId);
    }
}
