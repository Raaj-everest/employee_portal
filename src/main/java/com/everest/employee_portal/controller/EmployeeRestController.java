package com.everest.employee_portal.controller;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.repositories.EmployeeRepository;
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

    private final EmployeeService employeeService;

    @GetMapping("")
    public ResponseEntity<List<Employee>> getAllEmployees() {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getAll());

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Employee>> getEmployeeByID(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.getByID(id));
    }

    @PostMapping("")
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee) {
        Employee employee1 = employeeService.create(employee);
        return ResponseEntity.status(HttpStatus.CREATED).body("Employee Created with id :" + employee1.id + " successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee employee1 = employeeService.update(employee, id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee with id :" + employee1.id + " successfully");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable Long id) {
        Employee employee1 = employeeService.delete(id);
        return ResponseEntity.status(HttpStatus.OK).body("Employee with id :" + employee1.id + " successfully");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Employee>> searchEmployeesBy(@RequestParam String firstName,
                                                           @RequestParam String lastName) {
        return ResponseEntity.status(HttpStatus.OK).body(employeeService.searchBy(firstName, lastName));
    }


}
