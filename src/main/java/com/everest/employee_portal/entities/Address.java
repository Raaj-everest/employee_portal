package com.everest.employee_portal.entities;

import com.everest.employee_portal.entities.enums.AddressType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "address")
public class Address {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    public Long id;

    @Column(name = "type", nullable = false)
    private AddressType addressType;

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

    @Override
    public String toString() {
        return "Address{" +
                "addressType :'" + addressType + '\'' +
                "streetDetails :'" + streetDetails + '\'' +
                ", houseNumber :'" + houseNumber + '\'' +
                ", district :'" + district + '\'' +
                ", city :'" + city + '\'' +
                ", state :'" + state + '\'' +
                ", country :'" + country + '\'' +
                ", zipCode :'" + zipCode + '\'' +
                '}';
    }

}


