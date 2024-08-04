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
@Table(name = "consultation")

public class ConsultationEntity {

		    @Id
		    @GeneratedValue(strategy = GenerationType.IDENTITY)
		    private Long id;

		    @Column(unique=true,name = "consultation_number")
		    private String consultationNumber;

		    @Column(name = "Presenting_Complaint")
		    private String presentingComplaint;

		    @Column(name = "History_PC")
		    private String historyPC;
		    
		    @Column(name = "Pm_History")
		    private String pmhistory;
		    
		    @Column(name = "Past_surgeries")
		    private String pastsurgery;
		}
