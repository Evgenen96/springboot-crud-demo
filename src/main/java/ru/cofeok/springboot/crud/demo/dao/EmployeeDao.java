package ru.cofeok.springboot.crud.demo.dao;

import ru.cofeok.springboot.crud.demo.entity.Employee;

import java.util.List;

public interface EmployeeDao {
    public List<Employee> findAll();
}
