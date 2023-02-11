package com.example.springpartymanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class AppUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String username;
    private String password;

    @ManyToOne
    @JoinColumn(name = "user_role_id")
    private UserRole role;

    public String getRoleName() {
        return role.getName();
    }

    public AppUser(String username, String password, UserRole role) {
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public AppUser() {
    }

}
