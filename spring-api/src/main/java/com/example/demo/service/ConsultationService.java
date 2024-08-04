package com.example.demo.service;

import com.example.demo.dto.ConsultationDto;

import java.util.List;

public interface ConsultationService {	    
	    /**
	     * Create a new SignUp entry.
	     * 
	     * @param signupDto Data transfer object containing the signup details.
	     * @return SignUpDto Data transfer object with saved signup details.
	     */
	    ConsultationDto createConsultation(ConsultationDto consulDto);

	    /**
	     * Retrieve a SignUp entry by doctor ID.
	     * 
	     * @param doctorid The unique identifier for the doctor.
	     * @return SignUpDto Data transfer object with the retrieved signup details.
	     */
	    ConsultationDto getConsultationByConsulNo(String consultationNumber);

	    /**
	     * Retrieve all SignUp entries.
	     * 
	     * @return List<SignUpDto> List of data transfer objects containing all signup details.
	     */
	    List<ConsultationDto> getAllConsultation();

	    /**
	     * Update an existing SignUp entry identified by doctor ID.
	     * 
	     * @param doctorid The unique identifier for the doctor.
	     * @param updatedSignUp Data transfer object containing updated signup details.
	     * @return SignUpDto Data transfer object with the updated signup details.
	     */
	    ConsultationDto updateConsul(String consultationNumber, ConsultationDto updatedConsultation);

	    /**
	     * Delete a SignUp entry identified by doctor ID.
	     * 
	     * @param doctorid The unique identifier for the doctor.
	     */
	    void deleteConsultation(String consultationNumber);
	}
