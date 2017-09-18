package com.restmockservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.restmockservice.domain.Address;
import com.restmockservice.domain.Developer;
import com.restmockservice.domain.Skills;

import java.util.Optional;

public interface DeveloperDetailsRepository extends MongoRepository<Developer,String>{

	public Optional<Developer> findOneById(String id);
	public void save(Address address);
	public void save(Skills skills);
	
}
