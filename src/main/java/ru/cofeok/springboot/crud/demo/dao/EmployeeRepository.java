package ru.cofeok.springboot.crud.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import ru.cofeok.springboot.crud.demo.entity.Employee;

@RepositoryRestResource(path = "clients")
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
