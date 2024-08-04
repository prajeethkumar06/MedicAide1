package com.example.demo.repository;

import com.example.demo.entity.ConsultationEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * SignUpRepository is an interface that extends JpaRepository to provide CRUD operations for SignUpEntity.
 * This interface includes a custom method to find a SignUpEntity by the doctor ID.
 */
public interface ConsultationRepository extends JpaRepository<ConsultationEntity, Long> {

	    /**
	     * Finds a SignUpEntity by its doctor ID.
	     *
	     * @param consultationNumber The ID of the consultation.
	     * @return An Optional containing the SignUpEntity if found, or empty if not found.
	     */
	    Optional<ConsultationEntity> findByConsultationNumber(String consultationNumber);
	}
