package com.example.demo.service.impl;

import lombok.AllArgsConstructor;
import com.example.demo.dto.SignUpDto;
import com.example.demo.entity.SignUpEntity;
import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.mapper.SignUpMapper;
import com.example.demo.repository.SignUpRepository;
import com.example.demo.service.SignUpService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor

public class SignUpServiceImpl implements SignUpService {


	    private SignUpRepository signupRepository;

	    @Override
	    public SignUpDto createSignUp(SignUpDto signupDto) {

	        SignUpEntity signup = SignUpMapper.mapToSignUp(signupDto);
	        SignUpEntity savedSignUp = signupRepository.save(signup);
	        return SignUpMapper.mapToSignUpDto(savedSignUp);
	    }

	    @Override
	    public SignUpDto getSignUpById(Long Id) {
	        SignUpEntity signup = signupRepository.findById(Id)
	                .orElseThrow(() ->
	                        new ResourceNotFoundException("Sign up id does not exists : " + Id));

	        return SignUpMapper.mapToSignUpDto(signup);
	    }

	    @Override
	    public List<SignUpDto> getAllSignUp() {
	        List<SignUpEntity> signups = signupRepository.findAll();
	        return signups.stream().map((signup) -> SignUpMapper.mapToSignUpDto(signup))
	                .collect(Collectors.toList());
	    }

	    @Override
	    public SignUpDto updateSignUp(Long Id, SignUpDto updatedSignUp) {

	        SignUpEntity signup = signupRepository.findById(Id).orElseThrow(
	                () -> new ResourceNotFoundException("Sign up id does is not exists : " + Id)
	        );

	        signup.setFirstName(updatedSignUp.getFirstName());
	        signup.setLastName(updatedSignUp.getLastName());
	        signup.setEmail(updatedSignUp.getEmail());

	        SignUpEntity updatedSignUpObj = signupRepository.save(signup);

	        return SignUpMapper.mapToSignUpDto(updatedSignUpObj);
	    }

	    @Override
	    public void deleteSignUp(Long Id) {

	        SignUpEntity signup = signupRepository.findById(Id).orElseThrow(
	                () -> new ResourceNotFoundException("Sign up id does not exists : " + Id)
	        );

	        signupRepository.deleteById(Id);
	    }
	}
