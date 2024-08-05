package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.PrescriptionDto;
import com.example.demo.entity.PrescriptionEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.PrescriptionMapper;
import com.example.demo.repository.PrescriptionRepository;
import com.example.demo.service.PrescriptionService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for SignUpService.
 * This class provides methods to handle CRUD operations for SignUp entities.
 */
@Service
@AllArgsConstructor

public class PrescriptionServiceImpl implements PrescriptionService {

		    private final PrescriptionRepository prescRepository;

		    /**
		     * Creates a new SignUp entry.
		     * 
		     * @param signupDto Data Transfer Object containing sign-up details.
		     * @return The created SignUpDto.
		     */
		    @Override
		    public PrescriptionDto createPrescription(PrescriptionDto prescDto) {
		        // Map DTO to entity
		        PrescriptionEntity presc = PrescriptionMapper.mapToPrescription(prescDto);
		        // Save entity to repository
		        PrescriptionEntity savedpresc = prescRepository.save(presc);
		        // Map saved entity back to DTO and return
		        return PrescriptionMapper.mapToPrescriptionDto(savedpresc);
		    }

		    /**
		     * Retrieves a SignUp entry by doctor ID.
		     * 
		     * @param doctorid The ID of the doctor.
		     * @return The SignUpDto corresponding to the doctor ID.
		     * @throws ResourceNotFoundException if the doctor ID does not exist.
		     */
		    @Override
		    public PrescriptionDto getMedicineByMedicineName(String medicineName) {
		        // Find entity by doctor ID, throw exception if not found
		        PrescriptionEntity presc = prescRepository.findByMedicineName(medicineName)
		                .orElseThrow(() -> new ResourceNotFoundException("Doctor ID does not exist: " + medicineName));
		        // Map entity to DTO and return
		        return PrescriptionMapper.mapToPrescriptionDto(presc);
		    }

		    /**
		     * Retrieves all SignUp entries.
		     * 
		     * @return A list of all SignUpDto entries.
		     */
		    @Override
		    public List<PrescriptionDto> getAllPrescription() {
		        // Get all entities from repository
		        List<PrescriptionEntity> prescs = prescRepository.findAll();
		        // Map entities to DTOs and return as list
		        return prescs.stream().map(PrescriptionMapper::mapToPrescriptionDto)
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
		    public PrescriptionDto updatePresc(String medicineName, PrescriptionDto updatedPrescription) {
		        // Find entity by doctor ID, throw exception if not found
		        PrescriptionEntity presc = prescRepository.findByMedicineName(medicineName).orElseThrow(
		                () -> new ResourceNotFoundException("Medicine does not exist: " + medicineName)
		        );

		        // Update entity fields with new values
		        presc.setMedicineName(updatedPrescription.getMedicineName());// Update consultation number if needed
		        
		        // Save updated entity to repository
		        PrescriptionEntity updatedPresObj = prescRepository.save(presc);
		        // Map updated entity to DTO and return
		        return PrescriptionMapper.mapToPrescriptionDto(updatedPresObj);
		    }

		    /**
		     * Deletes a SignUp entry by doctor ID.
		     * 
		     * @param doctorid The ID of the doctor.
		     * @throws ResourceNotFoundException if the doctor ID does not exist.
		     */
		    @Override
		    public void deletePrescription(String medicineName) {
		        // Find entity by doctor ID, throw exception if not found
		        PrescriptionEntity presc = prescRepository.findByMedicineName(medicineName).orElseThrow(
		                () -> new ResourceNotFoundException("Doctor ID does not exist: " + medicineName)
		        );

		        // Delete entity from repository
		        prescRepository.delete(presc);
		    }
		}