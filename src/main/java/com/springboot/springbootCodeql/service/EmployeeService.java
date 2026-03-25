package com.springboot.springbootCodeql.service;

import com.springboot.springbootCodeql.model.Employee;
import com.springboot.springbootCodeql.repository.EmployeeRepository;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

    @Autowired
    private EntityManager entityManager;

    public EmployeeService(EmployeeRepository repository) {
        this.repository = repository;
    }

    public Employee create(Employee employee) {
        return repository.save(employee);
    }

    public Employee get(Long id) {
        return repository.findById(id).orElseThrow(() -> new NoSuchElementException("Employee not found: " + id));
    }

    public List<Employee> list() {
        return repository.findAll();
    }

    public Employee update(Long id, Employee updated) {
        Employee existing = get(id);
        existing.setFirstName(updated.getFirstName());
        existing.setLastName(updated.getLastName());
        existing.setEmail(updated.getEmail());
        return repository.save(existing);
    }

    
    public void delete(Long id) {
        repository.deleteById(id);
    }

    // VULNERABLE: SQL Injection - for CodeQL testing only
    @SuppressWarnings("unchecked")
    public List<Employee> searchByName(String name) {
        String query = "SELECT * FROM employees WHERE first_name = '" + name + "'";
        return entityManager.createNativeQuery(query, Employee.class).getResultList();
    }
}