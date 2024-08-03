package com.example.demo.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "signuppat")

public class SignUpPatEntity {
	
		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;

		    @Column(name = "first_name")
		    private String firstName;

		    @Column(name = "last_name")
		    private String lastName;

		    @Column(unique=true,name = "email_id")
		    private String email;
		    
		    @Column(unique=true,name = "patient_id")
		    private String patientid;
		    
		    @Column(name = "password")
		    private String password;
		}
