package com.example.demo.service.impl;


import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpPatDto;
import com.example.demo.entity.SignUpPatEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.SignUpPatMapper;
import com.example.demo.repository.SignUpPatRepository;
import com.example.demo.service.SignUpPatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for SignUpService.
 * This class provides methods to handle CRUD operations for SignUp entities.
 */
@Service
@AllArgsConstructor

public class SignUpPatServiceImpl implements SignUpPatService {


	    private final SignUpPatRepository signuppatRepository;

	    /**
	     * Creates a new SignUp entry.
	     * 
	     * @param signupDto Data Transfer Object containing sign-up details.
	     * @return The created SignUpDto.
	     */
	    @Override
	    public SignUpPatDto createSignUpPat(SignUpPatDto signuppatDto) {
	        // Map DTO to entity
	        SignUpPatEntity signuppat = SignUpPatMapper.mapToSignUpPat(signuppatDto);
	        // Save entity to repository
	        SignUpPatEntity savedSignUp = signuppatRepository.save(signuppat);
	        // Map saved entity back to DTO and return
	        return SignUpPatMapper.mapToSignUpPatDto(savedSignUp);
	    }

	    /**
	     * Retrieves a SignUp entry by doctor ID.
	     * 
	     * @param doctorid The ID of the doctor.
	     * @return The SignUpDto corresponding to the doctor ID.
	     * @throws ResourceNotFoundException if the doctor ID does not exist.
	     */
	    @Override
	    public SignUpPatDto getSignUpByPatientid(String patientid) {
	        // Find entity by doctor ID, throw exception if not found
	        SignUpPatEntity signuppat = signuppatRepository.findByPatientid(patientid)
	                .orElseThrow(() -> new ResourceNotFoundException("Doctor ID does not exist: " + patientid));
	        // Map entity to DTO and return
	        return SignUpPatMapper.mapToSignUpPatDto(signuppat);
	    }

	    /**
	     * Retrieves all SignUp entries.
	     * 
	     * @return A list of all SignUpDto entries.
	     */
	    @Override
	    public List<SignUpPatDto> getAllSignUpPats() {
	        // Get all entities from repository
	        List<SignUpPatEntity> signups = signuppatRepository.findAll();
	        // Map entities to DTOs and return as list
	        return signups.stream().map(SignUpPatMapper::mapToSignUpPatDto)
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
	    public SignUpPatDto updateSignUpPat(String patientid, SignUpPatDto updatedSignUp) {
	        // Find entity by doctor ID, throw exception if not found
	        SignUpPatEntity signup = signuppatRepository.findByPatientid(patientid).orElseThrow(
	                () -> new ResourceNotFoundException("Doctor ID does not exist: " + patientid)
	        );

	        // Update entity fields with new values
	        signup.setFirstName(updatedSignUp.getFirstName());
	        signup.setLastName(updatedSignUp.getLastName());
	        signup.setEmail(updatedSignUp.getEmail());
	        signup.setPatientid(updatedSignUp.getPatientid()); // Update patientid if needed
	        signup.setPassword(updatedSignUp.getPassword()); // Update password if needed

	        // Save updated entity to repository
	        SignUpPatEntity updatedSignUpObj = signuppatRepository.save(signup);
	        // Map updated entity to DTO and return
	        return SignUpPatMapper.mapToSignUpPatDto(updatedSignUpObj);
	    }

	    /**
	     * Deletes a SignUp entry by doctor ID.
	     * 
	     * @param doctorid The ID of the doctor.
	     * @throws ResourceNotFoundException if the doctor ID does not exist.
	     */
	    @Override
	    public void deleteSignUpPat(String patientid) {
	        // Find entity by doctor ID, throw exception if not found
	        SignUpPatEntity signup = signuppatRepository.findByPatientid(patientid).orElseThrow(
	                () -> new ResourceNotFoundException("Doctor ID does not exist: " + patientid)
	        );

	        // Delete entity from repository
	        signuppatRepository.delete(signup);
	    }
	}