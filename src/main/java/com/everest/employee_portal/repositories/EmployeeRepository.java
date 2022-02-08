package com.everest.employee_portal.repositories;

import com.everest.employee_portal.entities.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

}