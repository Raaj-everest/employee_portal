package com.everest.employee_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Employee {

    private final long id;
    private final Name name;
    private final LocalDate dateOfJoin;
    private final Designation designation;
    private final String everestEmail;
    private final Address presentAddress;
    private LocalDate dateOfBirth;
    private String personalEmail;
    private Address permanentAddress;
    private String bio;

}
