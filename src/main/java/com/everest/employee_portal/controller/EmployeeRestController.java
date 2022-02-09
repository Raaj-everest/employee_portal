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
       return  es.create(employee);
    }

    @PutMapping("/{id}")
    public Long updateEmployee( @PathVariable Long id,@RequestBody Employee employee){
        employee.setId(id);
        return  es.update(employee);
    }

    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable Long id){
        return es.delete(id);
    }


}
