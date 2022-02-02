package com.everest.employee_portal.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
public class Address {

    private String streetDetails;
    private String houseNumber;
    private String district;
    private String city;
    private String state;
    private String country;
    private String zipCode;


    public Address() {
        streetDetails = "";
        houseNumber = "";
        district = "";
        city = "";
        state = "";
        country = "";
        zipCode = "";
    }

    public boolean equals(Address right) {
        return houseNumber.equals(right.houseNumber)
                && streetDetails.equals(right.streetDetails)
                && city.equals(right.city)
                && state.equals(right.state)
                && country.equals(right.country)
                && zipCode.equals(right.zipCode);
    }

    @Override
    public String toString() {
        return "Address{" +
                "streetDetails='" + streetDetails + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", district='" + district + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                ", zipCode='" + zipCode + '\'' +
                '}';
    }
}


