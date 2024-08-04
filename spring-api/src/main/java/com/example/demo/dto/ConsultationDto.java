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

public class ConsultationDto {

			    private Long id;

			    @JsonProperty("consultation_number")
			    private String consultationNumber;

			    @JsonProperty("Presenting_Complaint")
			    private String presentingComplaint;

			    @JsonProperty("History_PC")
			    private String historyPC;
			    
			    @JsonProperty("Pm_History")
			    private String pmhistory;
			    
			    @JsonProperty("Past_surgeries")
			    private String pastsurgery;
			}
