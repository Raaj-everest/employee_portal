package com.everest.employee_portal.repositories;

import com.everest.employee_portal.entities.Name;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NameRepository extends JpaRepository<Name, Long> {

}