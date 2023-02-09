package com.example.springpartymanagement.repository;

import com.example.springpartymanagement.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, String> {
}