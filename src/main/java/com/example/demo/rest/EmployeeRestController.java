package com.example.demo.rest;

import com.example.demo.entity.Employee;
import com.example.demo.exception.EmployeeServiceException;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employees")
    public ResponseEntity<List<Employee>> findAll() {
        return new ResponseEntity<List<Employee>>(employeeService.findAll(), HttpStatus.OK);
    }

    @GetMapping("/employees/{employeeId}")
    public ResponseEntity<Employee> getEmployee(@PathVariable int employeeId) throws EmployeeServiceException {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null || theEmployee.getId() <= 0) {
            throw new EmployeeServiceException("Employee with id " + employeeId + " does not exist");
        }
        return new ResponseEntity<Employee>(theEmployee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity<Employee> addEmployee(@RequestBody Employee theEmployee) {
        theEmployee.setId(0);
        employeeService.save(theEmployee);
        return new ResponseEntity<Employee>(theEmployee, HttpStatus.OK);
    }

    @PutMapping("/employees")
    public ResponseEntity<Employee> updateEmployee(@RequestBody Employee theEmployee) {
        employeeService.save(theEmployee);
        return new ResponseEntity<Employee>(theEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/employees/{employeeId}")
    public String deleteEmployee(@PathVariable int employeeId) {
        Employee theEmployee = employeeService.findById(employeeId);
        if (theEmployee == null) {
            throw new RuntimeException("Employee with id " + employeeId + " does not exist");
        }
        employeeService.deleteById(employeeId);
        return "{\"employee_id\" : \"" + employeeId + "\","
                + "\"info\" : \" Employee has been successfully deleted\"}";
    }
}
