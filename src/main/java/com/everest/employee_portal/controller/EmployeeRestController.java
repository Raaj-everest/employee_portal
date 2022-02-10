package com.everest.employee_portal.controller;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeeRestController {

    private final EmployeeService es;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getEmployee() {
        return ResponseEntity.status(HttpStatus.OK).body(es.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(es.getByID(id));
    }

    @PostMapping("")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        Employee employee1 = es.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created with id :" + employee1.id + " successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee employee1 = es.update(employee, id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee with id :" + employee1.id + " successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Employee employee1 = es.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee with id :" + employee1.id + " successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> getEmployeesWith(@RequestParam String firstName,
                                                           @RequestParam String lastName) {
        return ResponseEntity.status(HttpStatus.OK).body(es.searchEmployeeWith(firstName, lastName));
    }


}
