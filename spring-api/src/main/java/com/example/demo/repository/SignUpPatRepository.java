package com.example.demo.repository;

import com.example.demo.entity.SignUpPatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * SignUpRepository is an interface that extends JpaRepository to provide CRUD operations for SignUpEntity.
 * This interface includes a custom method to find a SignUpEntity by the doctor ID.
 */
public interface SignUpPatRepository extends JpaRepository<SignUpPatEntity, Long> {

    /**
     * Finds a SignUpEntity by its doctor ID.
     *
     * @param patientid The ID of the doctor.
     * @return An Optional containing the SignUpEntity if found, or empty if not found.
     */
    Optional<SignUpPatEntity> findByPatientid(String patientid);
}
