package com.restmockservice.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restmockservice.domain.Developer;
import com.restmockservice.repository.DeveloperDetailsRepository;

@Service
public class DeveloperDetailsService {
	
	@Autowired
	private DeveloperDetailsRepository developerDetailsRepository;
	
	public Optional<Developer> getDeveloperDetails(String id) throws Exception{
		return developerDetailsRepository.findOneById(id);
	}

}
