package com.everest.employee_portal.controller;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("")
    public Long createEmployee( @RequestBody Employee employee){
        System.out.println( employee.getId());
        System.out.println(employee.getBio());
        System.out.println( employee.getDateOfBirth());
        System.out.println(employee.getDateOfJoin());
        System.out.println(  employee.getFirstName());
        System.out.println(employee.getEverestEmail());
        System.out.println( employee.getPersonalEmail());
        System.out.println(employee.getDesignation());
        System.out.println(  employee.getPermanentAddress());
        System.out.println(employee.getPresentAddress());
       return  es.create(employee);
    }


}
