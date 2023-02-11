package com.example.springpartymanagement.repository;

import com.example.springpartymanagement.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRoleRepository extends JpaRepository<UserRole, Long> {
}