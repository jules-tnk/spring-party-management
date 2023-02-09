package com.example.springpartymanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.*;
import org.hibernate.Hibernate;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "person")
public class Person {
    @Id
    @Column(name = "id", nullable = false)
    @ToString.Include
    private String cin;

    @Column(name = "name")
    @ToString.Include
    private String firstName;

    @Column(name = "last_name")
    @ToString.Include
    private String lastName;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Person person = (Person) o;
        return cin != null && Objects.equals(cin, person.cin);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}