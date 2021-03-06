package com.everest.employee_portal.entities;

import com.everest.employee_portal.entities.enums.Designation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employee")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "middle_name", nullable = false)
    private String middleName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "date_of_join", nullable = false)
    private LocalDate dateOfJoin;

    @Column(nullable = false)
    private Designation designation;

    @Column(name = "company_mail", nullable = false)
    private String everestEmail;

    @Column(name = "personal_mail")
    private String personalEmail;

    @Column
    private String bio;

    @OneToOne
    @JoinColumn(name = "present_address_id")
    private Address presentAddress;

    @OneToOne
    @JoinColumn(name = "permanent_address_id")
    private Address permanentAddress;


}
