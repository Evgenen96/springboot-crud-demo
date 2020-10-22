package ru.cofeok.springboot.crud.demo.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.cofeok.springboot.crud.demo.entity.Employee;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeDaoJpaImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoJpaImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery =
                entityManager.createQuery("from Employee", Employee.class);
        List<Employee> employees = theQuery.getResultList();
        return employees;
    }

    @Override
    public Employee findById(int theId) {
        Employee theEmployee = entityManager.find(Employee.class, theId);
        return theEmployee;
    }

    @Override
    public void save(Employee theEmployee) {
        entityManager.persist(theEmployee);
    }

    @Override
    public void deleteById(int theId) {
        Query theQuery = entityManager.createQuery("delete from Employee where id = :employeeId");
        theQuery.setParameter("employeeId", theId);
        theQuery.executeUpdate();
    }
}
