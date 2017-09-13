package com.restmockservice.service;

import org.springframework.stereotype.Service;

import com.restmockservice.domain.Developer;
import com.restmockservice.repository.DeveloperDetailsRepository;

@Service
public class DeveloperDetailsService {
	
	private DeveloperDetailsRepository developerDetailsRepository;
	
	public Developer getDeveloperDetails(String id) throws Exception{
		return developerDetailsRepository.findOneById(id);
	}

}
