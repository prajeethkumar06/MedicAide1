package com.example.demo.mapper;

import com.example.demo.dto.SignUpPatDto;
import com.example.demo.entity.SignUpPatEntity;

public class SignUpPatMapper {

		    public static SignUpPatDto mapToSignUpPatDto(SignUpPatEntity signuppat){
		        return new SignUpPatDto(
		                signuppat.getId(),
		                signuppat.getFirstName(),
		                signuppat.getLastName(),
		                signuppat.getEmail(),
		                signuppat.getPatientid(),
		                signuppat.getPassword()
		        );
		    }

		    public static SignUpPatEntity mapToSignUpPat(SignUpPatDto signuppatDto){
		        return new SignUpPatEntity(
		        		signuppatDto.getId(),
		                signuppatDto.getFirstName(),
		                signuppatDto.getLastName(),
		                signuppatDto.getEmail(),
		                signuppatDto.getPatientid(),
		                signuppatDto.getPassword()
		        );
		    }
	}
