package com.example.demo.controller;

import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpDto;
import com.example.demo.service.SignUpService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@AllArgsConstructor
@RestController
@RequestMapping("/api/signup")

public class SignUpController {

	    private SignUpService signupService;

	    // Build Add Employee REST API
	    @PostMapping
	    public ResponseEntity<SignUpDto> createSignUp(@RequestBody SignUpDto signupDto){
	        SignUpDto savedSignUp = signupService.createSignUp(signupDto);
	        return new ResponseEntity<>(savedSignUp, HttpStatus.CREATED);
	    }

	    // Build Get Employee REST API
	    @GetMapping("{doctorid}")
	    public ResponseEntity<SignUpDto> getSignUpById(@PathVariable("doctorid") Long Id){
	        SignUpDto employeeDto = signupService.getSignUpById(Id);
	        return ResponseEntity.ok(employeeDto);
	    }

	    // Build Get All Employees REST API
	    @GetMapping
	    public ResponseEntity<List<SignUpDto>> getAllSignUps(){
	        List<SignUpDto> signups = signupService.getAllSignUp();
	        return ResponseEntity.ok(signups);
	    }

	    // Build Update Employee REST API
	    @PutMapping("{doctorid}")
	    public ResponseEntity<SignUpDto> updateEmployee(@PathVariable("doctorid") Long Id,
	                                                      @RequestBody SignUpDto updatedSignUp){
	          SignUpDto signupDto = signupService.updateSignUp(Id, updatedSignUp);
	          return ResponseEntity.ok(signupDto);
	    }

	    // Build Delete Employee REST API
	    @DeleteMapping("{doctorid}")
	    public ResponseEntity<String> deleteEmployee(@PathVariable("doctorid") Long Id){
	        signupService.deleteSignUp(Id);
	        return ResponseEntity.ok("Doctor Id deleted successfully!.");
	    }
	}
