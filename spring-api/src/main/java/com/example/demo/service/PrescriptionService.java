package com.example.demo.service;

import com.example.demo.dto.PrescriptionDto;

import java.util.List;

public interface PrescriptionService {
		    /**
		     * Create a new SignUp entry.
		     * 
		     * @param signupDto Data transfer object containing the signup details.
		     * @return SignUpDto Data transfer object with saved signup details.
		     */
		    PrescriptionDto createPrescription(PrescriptionDto prescDto);

		    /**
		     * Retrieve a SignUp entry by doctor ID.
		     * 
		     * @param doctorid The unique identifier for the doctor.
		     * @return SignUpDto Data transfer object with the retrieved signup details.
		     */
		    PrescriptionDto getMedicineByMedicineName(String medicineName);

		    /**
		     * Retrieve all SignUp entries.
		     * 
		     * @return List<SignUpDto> List of data transfer objects containing all signup details.
		     */
		    List<PrescriptionDto> getAllPrescription();

		    /**
		     * Update an existing SignUp entry identified by doctor ID.
		     * 
		     * @param doctorid The unique identifier for the doctor.
		     * @param updatedSignUp Data transfer object containing updated signup details.
		     * @return SignUpDto Data transfer object with the updated signup details.
		     */
		    PrescriptionDto updatePresc(String medicineName, PrescriptionDto updatedPrescription);

		    /**
		     * Delete a SignUp entry identified by doctor ID.
		     * 
		     * @param doctorid The unique identifier for the doctor.
		     */
		    void deletePrescription(String medicineName);
		}
