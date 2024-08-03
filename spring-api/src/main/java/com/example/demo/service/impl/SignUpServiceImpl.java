package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.SignUpEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.SignUpMapper;
import com.example.demo.repository.SignUpRepository;
import com.example.demo.service.SignUpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for SignUpService.
 * This class provides methods to handle CRUD operations for SignUp entities.
 */
@Service
@AllArgsConstructor
public class SignUpServiceImpl implements SignUpService {

    private final SignUpRepository signupRepository;

    /**
     * Creates a new SignUp entry.
     * 
     * @param signupDto Data Transfer Object containing sign-up details.
     * @return The created SignUpDto.
     */
    @Override
    public SignUpDto createSignUp(SignUpDto signupDto) {
        // Map DTO to entity
        SignUpEntity signup = SignUpMapper.mapToSignUp(signupDto);
        // Save entity to repository
        SignUpEntity savedSignUp = signupRepository.save(signup);
        // Map saved entity back to DTO and return
        return SignUpMapper.mapToSignUpDto(savedSignUp);
    }

    /**
     * Retrieves a SignUp entry by doctor ID.
     * 
     * @param doctorid The ID of the doctor.
     * @return The SignUpDto corresponding to the doctor ID.
     * @throws ResourceNotFoundException if the doctor ID does not exist.
     */
    @Override
    public SignUpDto getSignUpByDoctorid(String doctorid) {
        // Find entity by doctor ID, throw exception if not found
        SignUpEntity signup = signupRepository.findByDoctorid(doctorid)
                .orElseThrow(() -> new ResourceNotFoundException("Doctor ID does not exist: " + doctorid));
        // Map entity to DTO and return
        return SignUpMapper.mapToSignUpDto(signup);
    }

    /**
     * Retrieves all SignUp entries.
     * 
     * @return A list of all SignUpDto entries.
     */
    @Override
    public List<SignUpDto> getAllSignUp() {
        // Get all entities from repository
        List<SignUpEntity> signups = signupRepository.findAll();
        // Map entities to DTOs and return as list
        return signups.stream().map(SignUpMapper::mapToSignUpDto)
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
    public SignUpDto updateSignUp(String doctorid, SignUpDto updatedSignUp) {
        // Find entity by doctor ID, throw exception if not found
        SignUpEntity signup = signupRepository.findByDoctorid(doctorid).orElseThrow(
                () -> new ResourceNotFoundException("Doctor ID does not exist: " + doctorid)
        );

        // Update entity fields with new values
        signup.setFirstName(updatedSignUp.getFirstName());
        signup.setLastName(updatedSignUp.getLastName());
        signup.setEmail(updatedSignUp.getEmail());
        signup.setDoctorid(updatedSignUp.getDoctorid()); // Update doctorid if needed
        signup.setPassword(updatedSignUp.getPassword()); // Update password if needed

        // Save updated entity to repository
        SignUpEntity updatedSignUpObj = signupRepository.save(signup);
        // Map updated entity to DTO and return
        return SignUpMapper.mapToSignUpDto(updatedSignUpObj);
    }

    /**
     * Deletes a SignUp entry by doctor ID.
     * 
     * @param doctorid The ID of the doctor.
     * @throws ResourceNotFoundException if the doctor ID does not exist.
     */
    @Override
    public void deleteSignUp(String doctorid) {
        // Find entity by doctor ID, throw exception if not found
        SignUpEntity signup = signupRepository.findByDoctorid(doctorid).orElseThrow(
                () -> new ResourceNotFoundException("Doctor ID does not exist: " + doctorid)
        );

        // Delete entity from repository
        signupRepository.delete(signup);
    }
}