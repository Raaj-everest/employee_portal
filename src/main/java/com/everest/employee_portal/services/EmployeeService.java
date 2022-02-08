package com.everest.employee_portal.services;

import com.everest.employee_portal.entities.Employee;
import com.everest.employee_portal.repositories.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;


}
