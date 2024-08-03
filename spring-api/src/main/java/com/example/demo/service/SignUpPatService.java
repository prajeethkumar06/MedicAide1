package com.example.demo.service;

import com.example.demo.dto.SignUpPatDto;

import java.util.List;

public interface SignUpPatService {	    
	    /**
	     * Create a new SignUp entry.
	     * 
	     * @param signupDto Data transfer object containing the signup details.
	     * @return SignUpDto Data transfer object with saved signup details.
	     */
	    SignUpPatDto createSignUpPat(SignUpPatDto signuppatDto);

	    /**
	     * Retrieve a SignUp entry by patient ID.
	     * 
	     * @param patientid The unique identifier for the patient.
	     * @return SignUpDto Data transfer object with the retrieved signup details.
	     */
	    SignUpPatDto getSignUpByPatientid(String patientid);

	    /**
	     * Retrieve all SignUp entries.
	     * 
	     * @return List<SignUpPatDto> List of data transfer objects containing all signup details.
	     */
	    List<SignUpPatDto> getAllSignUpPats();

	    /**
	     * Update an existing SignUp entry identified by patient ID.
	     * 
	     * @param patientid The unique identifier for the patient.
	     * @param updatedSignUp Data transfer object containing updated signup details.
	     * @return SignUpPatDto Data transfer object with the updated signup details.
	     */
	    SignUpPatDto updateSignUpPat(String patientid, SignUpPatDto updatedSignUp);

	    /**
	     * Delete a SignUp entry identified by patient ID.
	     * 
	     * @param patientid The unique identifier for the patient.
	     */
	    void deleteSignUpPat(String patientid);
	}
