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

public class SignUpPatDto {

		    private Long id;

		    @JsonProperty("first_name")
		    private String firstName;

		    @JsonProperty("last_name")
		    private String lastName;

		    @JsonProperty("email_id")
		    private String email;
		    
		    @JsonProperty("patient_id")
		    private String patientid;
		    
		    @JsonProperty("password")
		    private String password;
		}
