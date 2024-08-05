package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.PrescriptionDto;
import com.example.demo.service.PrescriptionService;
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
@RequestMapping("/api/prescription")

public class PrescriptionController {

	    private final PrescriptionService prescService;

	    /**
	     * Handles POST requests to create a new sign-up entry.
	     *
	     * @param signupDto Data Transfer Object containing sign-up details.
	     * @return ResponseEntity containing the created SignUpDto and HTTP status CREATED.
	     */
	    @PostMapping
	    public ResponseEntity<PrescriptionDto> createPrescription(@RequestBody PrescriptionDto prescDto) {
	        PrescriptionDto savedPresc = prescService.createPrescription(prescDto);
	        return new ResponseEntity<>(savedPresc, HttpStatus.CREATED);
	    }

	    /**
	     * Handles GET requests to retrieve a sign-up entry by doctor ID.
	     *
	     * @param doctorid The ID of the doctor.
	     * @return ResponseEntity containing the SignUpDto and HTTP status OK.
	     */
	    @GetMapping("{medicineName}")
	    public ResponseEntity<PrescriptionDto> getMedicineByMedicineName(@PathVariable("medicineName") String medicineName) {
	        PrescriptionDto prescDto = prescService.getMedicineByMedicineName(medicineName);
	        return ResponseEntity.ok(prescDto);
	    }

	    /**
	     * Handles GET requests to retrieve all sign-up entries.
	     *
	     * @return ResponseEntity containing a list of SignUpDto and HTTP status OK.
	     */
	    @GetMapping
	    public ResponseEntity<List<PrescriptionDto>> getAllPrescription() {
	        List<PrescriptionDto> prescs = prescService.getAllPrescription();
	        return ResponseEntity.ok(prescs);
	    }

	    /**
	     * Handles PUT requests to update a sign-up entry by doctor ID.
	     *
	     * @param medicineName The Name of the Medicine.
	     * @param updatedSignUp Data Transfer Object containing updated sign-up details.
	     * @return ResponseEntity containing the updated SignUpDto and HTTP status OK.
	     */

	    @PutMapping("{medicineName}")
	    public ResponseEntity<PrescriptionDto> updatePresc(@PathVariable("medicineName") String medicineName,
	                                                   @RequestBody PrescriptionDto updatedPrescription) {
	        PrescriptionDto prescDto = prescService.updatePresc(medicineName, updatedPrescription);
	        return ResponseEntity.ok(prescDto);
	    }

	    /**
	     * Handles DELETE requests to delete a sign-up entry by doctor ID.
	     *
	     * @param medicineName The Name of Medicine.
	     * @return ResponseEntity containing a success message and HTTP status OK.
	     */
		
	    @DeleteMapping("{medicineName}")
	    public ResponseEntity<String> deletePrescription(@PathVariable("medicineName") String medicineName) {
	        prescService.deletePrescription(medicineName);
	        return ResponseEntity.ok("Medicine deleted successfully.");
	    }
	}
