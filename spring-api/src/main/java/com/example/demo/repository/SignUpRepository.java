package com.example.demo.repository;

import com.example.demo.entity.SignUpEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * SignUpRepository is an interface that extends JpaRepository to provide CRUD operations for SignUpEntity.
 * This interface includes a custom method to find a SignUpEntity by the doctor ID.
 */
public interface SignUpRepository extends JpaRepository<SignUpEntity, Long> {

    /**
     * Finds a SignUpEntity by its doctor ID.
     *
     * @param doctorid The ID of the doctor.
     * @return An Optional containing the SignUpEntity if found, or empty if not found.
     */
    Optional<SignUpEntity> findByDoctorid(String doctorid);
}
