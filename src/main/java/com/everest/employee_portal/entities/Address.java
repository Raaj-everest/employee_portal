package com.everest.employee_portal.entities;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@Entity
@Table(name = "address")
public class Address {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "street")
    private String streetDetails;

    @Column(name = "house_number")
    private String houseNumber;

    @Column
    private String district;

    @Column
    private String city;

    @Column
    private String state;

    @Column
    private String country;

    @Column
    private Long zipCode;


    public Address() {
        streetDetails = "";
        houseNumber = "";
        district = "";
        city = "";
        state = "";
        country = "";
        zipCode = 0L;
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


