package com.everest.employee_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
public class Name {

    private final String firstName;
    private final String lastName;
    private String middleName;


    public String getTraditionalName() {
        return firstName + " " + lastName;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }
}
