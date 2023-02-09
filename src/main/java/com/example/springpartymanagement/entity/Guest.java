package com.example.springpartymanagement.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
public class Guest extends Person {
    @Enumerated(EnumType.STRING)
    @Column(name = "guest_status")
    private GuestStatus status;

    @ManyToMany
    @JoinTable(name = "null_weddings",
            joinColumns = @JoinColumn(name = "guest_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "weddings_id", referencedColumnName = "id"))
    private Set<Wedding> weddings = new LinkedHashSet<>();

    public Guest(String cin, String firstName, String lastName, GuestStatus status) {
        super(cin, firstName, lastName);
        this.status = status;
    }
}