package com.example.demo.service;

import com.example.demo.dto.SignUpDto;

import java.util.List;

public interface SignUpService {
    
    /**
     * Create a new SignUp entry.
     * 
     * @param signupDto Data transfer object containing the signup details.
     * @return SignUpDto Data transfer object with saved signup details.
     */
    SignUpDto createSignUp(SignUpDto signupDto);

    /**
     * Retrieve a SignUp entry by doctor ID.
     * 
     * @param doctorid The unique identifier for the doctor.
     * @return SignUpDto Data transfer object with the retrieved signup details.
     */
    SignUpDto getSignUpByDoctorid(String doctorid);

    /**
     * Retrieve all SignUp entries.
     * 
     * @return List<SignUpDto> List of data transfer objects containing all signup details.
     */
    List<SignUpDto> getAllSignUp();

    /**
     * Update an existing SignUp entry identified by doctor ID.
     * 
     * @param doctorid The unique identifier for the doctor.
     * @param updatedSignUp Data transfer object containing updated signup details.
     * @return SignUpDto Data transfer object with the updated signup details.
     */
    SignUpDto updateSignUp(String doctorid, SignUpDto updatedSignUp);

    /**
     * Delete a SignUp entry identified by doctor ID.
     * 
     * @param doctorid The unique identifier for the doctor.
     */
    void deleteSignUp(String doctorid);
}
