package com.restmockservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.restmockservice.domain.Address;
import com.restmockservice.domain.Developer;
import com.restmockservice.domain.Skills;

public interface DeveloperDetailsRepository extends MongoRepository<Developer,String>{

	public Developer findOneById(String id);
	public void save(Address address);
	public void save(Skills skills);
	
}
