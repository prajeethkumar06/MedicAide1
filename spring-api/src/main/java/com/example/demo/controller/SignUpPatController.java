package com.example.demo.controller;


import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpPatDto;
import com.example.demo.service.SignUpPatService;
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
@RequestMapping("/api/signuppat")

public class SignUpPatController {


	    private final SignUpPatService signuppatService;

	    /**
	     * Handles POST requests to create a new sign-up entry.
	     *
	     * @param signupDto Data Transfer Object containing sign-up details.
	     * @return ResponseEntity containing the created SignUpDto and HTTP status CREATED.
	     */
	    @PostMapping
	    public ResponseEntity<SignUpPatDto> createSignUpPat(@RequestBody SignUpPatDto signuppatDto) {
	        SignUpPatDto savedSignUpPat = signuppatService.createSignUpPat(signuppatDto);
	        return new ResponseEntity<>(savedSignUpPat, HttpStatus.CREATED);
	    }

	    /**
	     * Handles GET requests to retrieve a sign-up entry by doctor ID.
	     *
	     * @param patientid The ID of the doctor.
	     * @return ResponseEntity containing the SignUpDto and HTTP status OK.
	     */
	    @GetMapping("{patientid}")
	    public ResponseEntity<SignUpPatDto> getSignUpByPatientid(@PathVariable("patientid") String patientid) {
	        SignUpPatDto signuppatDto = signuppatService.getSignUpByPatientid(patientid);
	        return ResponseEntity.ok(signuppatDto);
	    }

	    /**
	     * Handles GET requests to retrieve all sign-up entries.
	     *
	     * @return ResponseEntity containing a list of SignUpDto and HTTP status OK.
	     */
	    @GetMapping
	    public ResponseEntity<List<SignUpPatDto>> getAllSignUpPats() {
	        List<SignUpPatDto> signups = signuppatService.getAllSignUpPats();
	        return ResponseEntity.ok(signups);
	    }

	    /**
	     * Handles PUT requests to update a sign-up entry by doctor ID.
	     *
	     * @param doctorid The ID of the doctor.
	     * @param updatedSignUp Data Transfer Object containing updated sign-up details.
	     * @return ResponseEntity containing the updated SignUpDto and HTTP status OK.
	     */

	    @PutMapping("{patientid}")
	    public ResponseEntity<SignUpPatDto> updateSignUpPat(@PathVariable("patientid") String patientid,
	                                                   @RequestBody SignUpPatDto updatedSignUp) {
	        SignUpPatDto signupDto = signuppatService.updateSignUpPat(patientid, updatedSignUp);
	        return ResponseEntity.ok(signupDto);
	    }

	    /**
	     * Handles DELETE requests to delete a sign-up entry by doctor ID.
	     *
	     * @param doctorid The ID of the doctor.
	     * @return ResponseEntity containing a success message and HTTP status OK.
	     */
		
	    @DeleteMapping("{patientid}")
	    public ResponseEntity<String> deleteSignUpPat(@PathVariable("patientid") String patientid) {
	        signuppatService.deleteSignUpPat(patientid);
	        return ResponseEntity.ok("Doctor ID deleted successfully.");
	    }
	}
