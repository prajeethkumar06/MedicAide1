package com.example.demo.mapper;

import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.SignUpEntity;

public class SignUpMapper {

	    public static SignUpDto mapToSignUpDto(SignUpEntity signup){
	        return new SignUpDto(
	                signup.getId(),
	                signup.getFirstName(),
	                signup.getLastName(),
	                signup.getEmail(),
	                signup.getDoctorid(),
	                signup.getPassword()
	        );
	    }

	    public static SignUpEntity mapToSignUp(SignUpDto signupDto){
	        return new SignUpEntity(
	        		signupDto.getId(),
	                signupDto.getFirstName(),
	                signupDto.getLastName(),
	                signupDto.getEmail(),
	                signupDto.getDoctorid(),
	                signupDto.getPassword()
	        );
	    }
	}
