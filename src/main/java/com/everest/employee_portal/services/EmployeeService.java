package com.everest.employee_portal.services;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.repositories.AddressRepository;
import com.everest.employee_portal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;
    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getByID(Long id) {
        return employeeRepository.findById(id);
    }

    @Transactional
    public Long create(Employee employee) {
        addressRepository.save(employee.getPermanentAddress());
        addressRepository.save(employee.getPresentAddress());
        Employee createdEmployee = employeeRepository.save(employee);
        return Long.valueOf(createdEmployee.getId());
    }


}
