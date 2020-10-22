package ru.cofeok.springboot.crud.demo.service;

import ru.cofeok.springboot.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeService {

    List<Employee> findAll();

    Employee findById(int theId);

    void save(Employee theEmployee);

    void deleteById(int theId);
}
