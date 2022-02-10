package com.everest.employee_portal.services;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.exceptions.EmployeeNotFoundException;
import com.everest.employee_portal.repositories.AddressRepository;
import com.everest.employee_portal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;
    private final AddressRepository addressRepository;

    public List<Employee> getAll() {
        return employeeRepository.findAll();
    }

    public Optional<Employee> getByID(Long id) {
        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new EmployeeNotFoundException("Employee with given "+id+" is not found");
        }
        return employee;
    }

    public Employee create(Employee employee) {
        addressRepository.save(employee.getPermanentAddress());
        addressRepository.save(employee.getPresentAddress());
        employeeRepository.save(employee);
        return employee;
    }

    public Employee update(Employee employee, Long id) {
        Employee employee1 = employeeRepository.getById(id);
        if (employee1.id == null) {
            throw new EmployeeNotFoundException("Employee with given "+id+" is not found");
        }
        Long permanentAddressId = employee1.getPermanentAddress().getId();
        Long presentAddressId = employee1.getPresentAddress().getId();
        employee.getPermanentAddress().setId(permanentAddressId);
        employee.getPresentAddress().setId(presentAddressId);
        addressRepository.save(employee.getPermanentAddress());
        addressRepository.save(employee.getPresentAddress());
        employeeRepository.save(employee);
        return employee;
    }

    public Employee delete(Long id) {
        Employee employee = employeeRepository.getById(id);
        if(employee.id==null){
            throw new EmployeeNotFoundException("Employee with given "+id+" is not found");
        }
        addressRepository.delete(employee.getPermanentAddress());
        addressRepository.delete(employee.getPresentAddress());
        employeeRepository.delete(employee);
        return employee;
    }

    public List<Employee> searchBy(String firstName, String lastName) {
        return employeeRepository.findByFirstNameAndLastName(firstName, lastName);

    }
}
