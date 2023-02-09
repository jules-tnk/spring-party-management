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
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "room")
public class Room {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    @ToString.Include
    private String name;

    @Column(name = "city")
    @ToString.Include
    private String city;

    @Column(name = "address")
    private String address;

    @Column(name = "capacity")
    private Integer capacity;

    @OneToMany(mappedBy = "room")
    private Set<Wedding> weddings = new LinkedHashSet<>();


    public Room(String name, String city, String address, Integer capacity) {
        this.name = name;
        this.city = city;
        this.address = address;
        this.capacity = capacity;
    }
}