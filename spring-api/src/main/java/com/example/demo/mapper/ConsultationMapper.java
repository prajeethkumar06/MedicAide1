package com.example.demo.mapper;

import com.example.demo.dto.ConsultationDto;
import com.example.demo.entity.ConsultationEntity;

public class ConsultationMapper {
	
		    public static ConsultationDto mapToConsultationDto(ConsultationEntity consul){
		        return new ConsultationDto(
		                consul.getId(),
		                consul.getConsultationNumber(),
		                consul.getPresentingComplaint(),
		                consul.getHistoryPC(),
		                consul.getPmhistory(),
		                consul.getPastsurgery()
		        );
		    }

		    public static ConsultationEntity mapToConsultation(ConsultationDto consulDto){
		        return new ConsultationEntity(
		        		consulDto.getId(),
		                consulDto.getConsultationNumber(),
		                consulDto.getPresentingComplaint(),
		                consulDto.getHistoryPC(),
		                consulDto.getPmhistory(),
		                consulDto.getPastsurgery()
		        );
		    }
		}
