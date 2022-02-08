package com.everest.employee_portal.repositories;

import com.everest.employee_portal.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<Address, Long> {

}