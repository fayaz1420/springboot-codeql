package com.springboot.springbootCodeql.service;

import com.springboot.springbootCodeql.model.Employee;
import com.springboot.springbootCodeql.repository.EmployeeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.NoSuchElementException;

@Service
@Transactional
public class EmployeeService {

    private final EmployeeRepository repository;

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
}
