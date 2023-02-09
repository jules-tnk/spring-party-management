package com.example.springpartymanagement.repository;

import com.example.springpartymanagement.entity.Guest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RepositoryRestResource(collectionResourceRel = "guest", path = "guest-repos-api")
public interface GuestRepository extends JpaRepository<Guest, String> {
    List<Guest> findAllByFirstNameContainsOrLastNameContainsIgnoreCase(String firstName, String lastName);
}