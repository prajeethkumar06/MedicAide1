package com.example.demo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class SignUpDto {



	    private Long id;

	    @JsonProperty("first_name")
	    private String firstName;

	    @JsonProperty("last_name")
	    private String lastName;

	    @JsonProperty("email_id")
	    private String email;
	    
	    @JsonProperty("doctor_id")
	    private String doctorid;
	    
	    @JsonProperty("password")
	    private String password;
	}
