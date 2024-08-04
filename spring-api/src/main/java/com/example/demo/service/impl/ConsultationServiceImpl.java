package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.ConsultationDto;
import com.example.demo.entity.ConsultationEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.ConsultationMapper;
import com.example.demo.repository.ConsultationRepository;
import com.example.demo.service.ConsultationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for SignUpService.
 * This class provides methods to handle CRUD operations for SignUp entities.
 */
@Service
@AllArgsConstructor

public class ConsultationServiceImpl implements ConsultationService{

	    private final ConsultationRepository consulRepository;

	    /**
	     * Creates a new SignUp entry.
	     * 
	     * @param signupDto Data Transfer Object containing sign-up details.
	     * @return The created SignUpDto.
	     */
	    @Override
	    public ConsultationDto createConsultation(ConsultationDto consulDto) {
	        // Map DTO to entity
	        ConsultationEntity consul = ConsultationMapper.mapToConsultation(consulDto);
	        // Save entity to repository
	        ConsultationEntity savedconsul = consulRepository.save(consul);
	        // Map saved entity back to DTO and return
	        return ConsultationMapper.mapToConsultationDto(savedconsul);
	    }

	    /**
	     * Retrieves a SignUp entry by doctor ID.
	     * 
	     * @param doctorid The ID of the doctor.
	     * @return The SignUpDto corresponding to the doctor ID.
	     * @throws ResourceNotFoundException if the doctor ID does not exist.
	     */
	    @Override
	    public ConsultationDto getConsultationByConsulNo(String consultationNumber) {
	        // Find entity by doctor ID, throw exception if not found
	        ConsultationEntity consul = consulRepository.findByConsultationNumber(consultationNumber)
	                .orElseThrow(() -> new ResourceNotFoundException("Doctor ID does not exist: " + consultationNumber));
	        // Map entity to DTO and return
	        return ConsultationMapper.mapToConsultationDto(consul);
	    }

	    /**
	     * Retrieves all SignUp entries.
	     * 
	     * @return A list of all SignUpDto entries.
	     */
	    @Override
	    public List<ConsultationDto> getAllConsultation() {
	        // Get all entities from repository
	        List<ConsultationEntity> consuls = consulRepository.findAll();
	        // Map entities to DTOs and return as list
	        return consuls.stream().map(ConsultationMapper::mapToConsultationDto)
	                .collect(Collectors.toList());
	    }

	    /**
	     * Updates an existing SignUp entry by doctor ID.
	     * 
	     * @param doctorid The ID of the doctor.
	     * @param updatedSignUp The updated sign-up details.
	     * @return The updated SignUpDto.
	     * @throws ResourceNotFoundException if the doctor ID does not exist.
	     */
	    @Override
	    public ConsultationDto updateConsul(String consultationNumber, ConsultationDto updatedConsultation) {
	        // Find entity by doctor ID, throw exception if not found
	        ConsultationEntity consul = consulRepository.findByConsultationNumber(consultationNumber).orElseThrow(
	                () -> new ResourceNotFoundException("Doctor ID does not exist: " + consultationNumber)
	        );

	        // Update entity fields with new values
	        consul.setConsultationNumber(updatedConsultation.getConsultationNumber());// Update consultation number if needed
	        consul.setPresentingComplaint(updatedConsultation.getPresentingComplaint());
	        consul.setHistoryPC(updatedConsultation.getHistoryPC());
	        consul.setPmhistory(updatedConsultation.getPmhistory()); 
	        consul.setPastsurgery(updatedConsultation.getPastsurgery());

	        // Save updated entity to repository
	        ConsultationEntity updatedConsulObj = consulRepository.save(consul);
	        // Map updated entity to DTO and return
	        return ConsultationMapper.mapToConsultationDto(updatedConsulObj);
	    }

	    /**
	     * Deletes a SignUp entry by doctor ID.
	     * 
	     * @param doctorid The ID of the doctor.
	     * @throws ResourceNotFoundException if the doctor ID does not exist.
	     */
	    @Override
	    public void deleteConsultation(String consultationNumber) {
	        // Find entity by doctor ID, throw exception if not found
	        ConsultationEntity consul = consulRepository.findByConsultationNumber(consultationNumber).orElseThrow(
	                () -> new ResourceNotFoundException("Doctor ID does not exist: " + consultationNumber)
	        );

	        // Delete entity from repository
	        consulRepository.delete(consul);
	    }
	}