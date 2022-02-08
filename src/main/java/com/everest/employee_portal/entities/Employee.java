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

    @OneToOne
    @JoinColumn(name = "name_id")
    private Name name_id;

    @Column(name = "date_of_join")
    private LocalDate dateOfJoin;

    @Column
    private Designation designation;

    @Column(name = "company_mail")
    private String everestEmail;

    @OneToOne
    @JoinColumn(name = "present_address_id")
    private Address presentAddress;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "personal_mail")
    private String personalEmail;

    @OneToOne
    @JoinColumn(name = "permanent_address_id")
    private Address permanentAddress;

    @Column
    private String bio;


}
