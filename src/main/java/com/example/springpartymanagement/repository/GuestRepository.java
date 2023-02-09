package com.example.springpartymanagement.repository;

import com.example.springpartymanagement.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest, String> {
}