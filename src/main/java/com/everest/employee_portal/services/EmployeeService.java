package com.everest.employee_portal.services;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.repositories.AddressRepository;
import com.everest.employee_portal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDate;
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
        return employeeRepository.findById(id);
    }

    public Long create(Employee employee) {
        addressRepository.save(employee.getPermanentAddress());
        addressRepository.save(employee.getPresentAddress());
        Employee createdEmployee = employeeRepository.save(employee);
        return createdEmployee.getId();
    }

    public Long update(Employee employee,Long employeeId) {
        Employee employee1 = employeeRepository.getById(employeeId);
        Long permanentAddressId = employee1.getPermanentAddress().getId();
        Long presentAddressId = employee1.getPresentAddress().getId();
        employee.getPermanentAddress().setId(permanentAddressId);
        employee.getPresentAddress().setId(presentAddressId);
        addressRepository.save(employee.getPermanentAddress());
        addressRepository.save(employee.getPresentAddress());
        employeeRepository.save(employee);
        return employee.getId();
    }

    public String delete(Long id) {
        Employee employee = employeeRepository.getById(id);
        addressRepository.delete(employee.getPermanentAddress());
        addressRepository.delete(employee.getPresentAddress());
        employeeRepository.delete(employee);
        return "Employee with " + id + "deleted successfully";
    }

    public List<Employee> searchEmployeeWith(String firstName, String lastName, String dateOfJoin) {
        System.out.println(dateOfJoin + " in service class");
       return employeeRepository.findByFirstNameAndLastName(firstName,lastName);
    }
}
