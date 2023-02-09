package com.example.springpartymanagement.repository;

import com.example.springpartymanagement.entity.Wedding;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WeddingRepository extends JpaRepository<Wedding, Long> {
}