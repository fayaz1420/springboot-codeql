package com.springboot.springbootCodeql.controller;

import com.springboot.springbootCodeql.model.Employee;
import com.springboot.springbootCodeql.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/employees")
public class Controller {

    private final EmployeeService service;

    public Controller(EmployeeService service) {
        this.service = service;
    }

    @GetMapping
    public List<Employee> list() {
        return service.list();
    }

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee created = service.create(employee);
        return ResponseEntity.created(URI.create("/employees/" + created.getId())).body(created);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Employee> get(@PathVariable Long id) {
        return ResponseEntity.ok(service.get(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Employee> update(@PathVariable Long id, @RequestBody Employee employee) {
        Employee updated = service.update(id, employee);
        return ResponseEntity.ok(updated); 
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    // VULNERABLE: Passes user input directly to SQL-injectable method
    @GetMapping("/search")
    public List<Employee> search(@RequestParam String name) {
        return service.searchByName(name);
    }
}