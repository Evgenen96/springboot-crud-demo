package ru.cofeok.springboot.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.cofeok.springboot.crud.demo.entity.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
