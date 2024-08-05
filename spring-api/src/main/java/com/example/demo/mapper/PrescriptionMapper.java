package com.example.demo.mapper;


import com.example.demo.dto.PrescriptionDto;
import com.example.demo.entity.PrescriptionEntity;

public class PrescriptionMapper {
	
		    public static PrescriptionDto mapToPrescriptionDto(PrescriptionEntity prescription){
		        return new PrescriptionDto(
		                prescription.getId(),
		                prescription.getMedicineName()
		        );
		    }

		    public static PrescriptionEntity mapToPrescription(PrescriptionDto prescriptionDto){
		        return new PrescriptionEntity(
		        		 	prescriptionDto.getId(),
			                prescriptionDto.getMedicineName()
		        );
		    }
		}
