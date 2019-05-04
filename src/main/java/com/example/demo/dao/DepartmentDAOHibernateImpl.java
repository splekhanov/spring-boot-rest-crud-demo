package com.example.demo.dao;

import com.example.demo.entity.Department;
import com.example.demo.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class DepartmentDAOHibernateImpl implements DepartmentDAO {

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Department> findAllDepartments() {
        Session currentSession = entityManager.unwrap(Session.class);
        Query<Department> theQuery = currentSession.createQuery("from Department", Department.class);
        List<Department> departments = theQuery.getResultList();
        return departments;
    }

    @Override
    public Department findDepartmentById(int departmentId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Department department = currentSession.get(Department.class, departmentId);
        return department;
    }

    @Override
    public void save(Department theDepartment) {
        Session currentSession = entityManager.unwrap(Session.class);
        currentSession.saveOrUpdate(theDepartment);
    }

    @Override
    public void deleteById(int theId) {
        Session currentSession = entityManager.unwrap(Session.class);
        Query theQuery = currentSession.createQuery("delete from Department where id=:departmentId");
        theQuery.setParameter("departmentId", theId);
        theQuery.executeUpdate();
    }
}
