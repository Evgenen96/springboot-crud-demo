package ru.cofeok.springboot.crud.demo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.cofeok.springboot.crud.demo.dao.EmployeeDao;
import ru.cofeok.springboot.crud.demo.entity.Employee;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeRestController {

    private EmployeeDao employeeDao;

    @Autowired
    public EmployeeRestController(EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @GetMapping("/employees")
    public List<Employee> findAll() {
        return employeeDao.findAll();
    }
}
