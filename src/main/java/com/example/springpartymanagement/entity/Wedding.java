package com.example.springpartymanagement.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
@Entity
@ToString(onlyExplicitlyIncluded = true)
@Table(name = "wedding")
public class Wedding {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    @ToString.Include
    private Long num;

    @Column(name = "date")
    @ToString.Include
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "room_id")
    @ToString.Include
    private Room room;

    @ManyToMany(mappedBy = "weddings")
    private Set<Guest> guests = new LinkedHashSet<>();

    public Wedding(LocalDate date, Room room) {
        this.date = date;
        this.room = room;
    }
}