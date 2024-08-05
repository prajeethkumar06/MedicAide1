package com.example.demo.repository;


import com.example.demo.entity.PrescriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * SignUpRepository is an interface that extends JpaRepository to provide CRUD operations for SignUpEntity.
 * This interface includes a custom method to find a SignUpEntity by the doctor ID.
 */
public interface PrescriptionRepository extends JpaRepository<PrescriptionEntity, Long> {
	    /**
	     * Finds a SignUpEntity by its doctor ID.
	     *
	     * @param medicineName The Name Of the Medicine.
	     * @return An Optional containing the SignUpEntity if found, or empty if not found.
	     */
	    Optional<PrescriptionEntity> findByMedicineName(String medicineName);
	}
