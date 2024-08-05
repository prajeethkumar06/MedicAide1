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
@Table(name = "prescription")

public class PrescriptionEntity {
	
			    @Id
			    @GeneratedValue(strategy = GenerationType.IDENTITY)
			    private Long id;
			    
			    @Column(name = "Medicine_Name")
			    private String medicineName;
			}