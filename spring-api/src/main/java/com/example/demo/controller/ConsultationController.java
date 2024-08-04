package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.ConsultationDto;
import com.example.demo.service.ConsultationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * REST controller for managing sign-up entities.
 */
@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/consultation")

public class ConsultationController {

	    private final ConsultationService consulService;

	    /**
	     * Handles POST requests to create a new sign-up entry.
	     *
	     * @param signupDto Data Transfer Object containing sign-up details.
	     * @return ResponseEntity containing the created SignUpDto and HTTP status CREATED.
	     */
	    @PostMapping
	    public ResponseEntity<ConsultationDto> createConsultation(@RequestBody ConsultationDto consulDto) {
	        ConsultationDto savedConsul = consulService.createConsultation(consulDto);
	        return new ResponseEntity<>(savedConsul, HttpStatus.CREATED);
	    }

	    /**
	     * Handles GET requests to retrieve a sign-up entry by doctor ID.
	     *
	     * @param doctorid The ID of the doctor.
	     * @return ResponseEntity containing the SignUpDto and HTTP status OK.
	     */
	    @GetMapping("{consultationNumber}")
	    public ResponseEntity<ConsultationDto> getConsultationByConsulNo(@PathVariable("consultationNumber") String consultationNumber) {
	        ConsultationDto consulDto = consulService.getConsultationByConsulNo(consultationNumber);
	        return ResponseEntity.ok(consulDto);
	    }

	    /**
	     * Handles GET requests to retrieve all sign-up entries.
	     *
	     * @return ResponseEntity containing a list of SignUpDto and HTTP status OK.
	     */
	    @GetMapping
	    public ResponseEntity<List<ConsultationDto>> getAllConsultations() {
	        List<ConsultationDto> consuls = consulService.getAllConsultation();
	        return ResponseEntity.ok(consuls);
	    }

	    /**
	     * Handles PUT requests to update a sign-up entry by doctor ID.
	     *
	     * @param doctorid The ID of the doctor.
	     * @param updatedSignUp Data Transfer Object containing updated sign-up details.
	     * @return ResponseEntity containing the updated SignUpDto and HTTP status OK.
	     */

	    @PutMapping("{consultationNumber}")
	    public ResponseEntity<ConsultationDto> updateConsul(@PathVariable("consultationNumber") String consultationNumber,
	                                                   @RequestBody ConsultationDto updatedConsultation) {
	        ConsultationDto consulDto = consulService.updateConsul(consultationNumber, updatedConsultation);
	        return ResponseEntity.ok(consulDto);
	    }

	    /**
	     * Handles DELETE requests to delete a sign-up entry by doctor ID.
	     *
	     * @param doctorid The ID of the doctor.
	     * @return ResponseEntity containing a success message and HTTP status OK.
	     */
		
	    @DeleteMapping("{consultationNumber}")
	    public ResponseEntity<String> deleteConsultation(@PathVariable("consultationNumber") String consultationNumber) {
	        consulService.deleteConsultation(consultationNumber);
	        return ResponseEntity.ok("Consultation deleted successfully.");
	    }
	}
