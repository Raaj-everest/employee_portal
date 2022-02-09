package com.everest.employee_portal.controller;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/employees")
public class EmployeeRestController {

    private final EmployeeService es;

    @GetMapping("")
    public List<Employee> getEmployee() {
        return es.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Employee> getByID(@PathVariable Long id) {
        return es.getByID(id);
    }


}
