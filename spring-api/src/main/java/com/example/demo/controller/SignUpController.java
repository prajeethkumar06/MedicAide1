package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpDto;
import com.example.demo.service.SignUpService;
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
@RequestMapping("/api/signup")
public class SignUpController {

    private final SignUpService signupService;

    /**
     * Handles POST requests to create a new sign-up entry.
     *
     * @param signupDto Data Transfer Object containing sign-up details.
     * @return ResponseEntity containing the created SignUpDto and HTTP status CREATED.
     */
    @PostMapping
    public ResponseEntity<SignUpDto> createSignUp(@RequestBody SignUpDto signupDto) {
        SignUpDto savedSignUp = signupService.createSignUp(signupDto);
        return new ResponseEntity<>(savedSignUp, HttpStatus.CREATED);
    }

    /**
     * Handles GET requests to retrieve a sign-up entry by doctor ID.
     *
     * @param doctorid The ID of the doctor.
     * @return ResponseEntity containing the SignUpDto and HTTP status OK.
     */
    @GetMapping("{doctorid}")
    public ResponseEntity<SignUpDto> getSignUpByDoctorid(@PathVariable("doctorid") String doctorid) {
        SignUpDto signupDto = signupService.getSignUpByDoctorid(doctorid);
        return ResponseEntity.ok(signupDto);
    }

    /**
     * Handles GET requests to retrieve all sign-up entries.
     *
     * @return ResponseEntity containing a list of SignUpDto and HTTP status OK.
     */
    @GetMapping
    public ResponseEntity<List<SignUpDto>> getAllSignUps() {
        List<SignUpDto> signups = signupService.getAllSignUp();
        return ResponseEntity.ok(signups);
    }

    /**
     * Handles PUT requests to update a sign-up entry by doctor ID.
     *
     * @param doctorid The ID of the doctor.
     * @param updatedSignUp Data Transfer Object containing updated sign-up details.
     * @return ResponseEntity containing the updated SignUpDto and HTTP status OK.
     */

    @PutMapping("{doctorid}")
    public ResponseEntity<SignUpDto> updateSignUp(@PathVariable("doctorid") String doctorid,
                                                   @RequestBody SignUpDto updatedSignUp) {
        SignUpDto signupDto = signupService.updateSignUp(doctorid, updatedSignUp);
        return ResponseEntity.ok(signupDto);
    }

    /**
     * Handles DELETE requests to delete a sign-up entry by doctor ID.
     *
     * @param doctorid The ID of the doctor.
     * @return ResponseEntity containing a success message and HTTP status OK.
     */
	
    @DeleteMapping("{doctorid}")
    public ResponseEntity<String> deleteSignUp(@PathVariable("doctorid") String doctorid) {
        signupService.deleteSignUp(doctorid);
        return ResponseEntity.ok("Doctor ID deleted successfully.");
    }
}
