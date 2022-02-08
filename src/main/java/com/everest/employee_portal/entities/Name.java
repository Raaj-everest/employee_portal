package com.everest.employee_portal.entities;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class Name {

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "second_name", nullable = false)
    private String lastName;

    @Column(name = "middle_name")
    private String middleName;

    public String getTraditionalName() {
        return firstName + " " + lastName;
    }

    public String getFullName() {
        return firstName + " " + middleName + " " + lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Name name = (Name) o;
        return id != null && Objects.equals(id, name.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
