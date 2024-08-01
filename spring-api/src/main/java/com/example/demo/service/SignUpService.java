package com.example.demo.service;

import com.example.demo.dto.SignUpDto;

import java.util.List;

public interface SignUpService{

    SignUpDto createSignUp(SignUpDto signupDto);

    SignUpDto getSignUpById(Long Id);

    List<SignUpDto> getAllSignUp();

    SignUpDto updateSignUp(Long Id, SignUpDto updatedSignUp);

    void deleteSignUp(Long Id);
}