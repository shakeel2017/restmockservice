package com.restmockservice.service;

import java.io.IOException;

import org.springframework.stereotype.Service;

import com.restmockservice.domain.Developer;
import com.restmockservice.repository.DeveloperDetailsRepository;

@Service
public class DeveloperDetailsService {
	
	private DeveloperDetailsRepository developerDetailsRepository;
	
	public Developer getDeveloperDetails(String id) throws IOException{
		return developerDetailsRepository.findOneById(id);
	}

}
