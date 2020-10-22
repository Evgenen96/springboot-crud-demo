package ru.cofeok.springboot.crud.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cofeok.springboot.crud.demo.dao.EmployeeDao;
import ru.cofeok.springboot.crud.demo.entity.Employee;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeDao employeeDao;

    @Value("${spring.dao.method}")
    private String daoMethod;

    // todo how to configure bean here
    @Autowired
    public EmployeeServiceImpl(@Qualifier("employeeDaoJpaImpl") EmployeeDao theEmployeeDao) {
        employeeDao = theEmployeeDao;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {
        System.out.println(daoMethod);
        return employeeDao.findAll();
    }

    @Override
    @Transactional
    public Employee findById(int theId) {
        return employeeDao.findById(theId);
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        employeeDao.save(theEmployee);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
        employeeDao.deleteById(theId);
    }
}
