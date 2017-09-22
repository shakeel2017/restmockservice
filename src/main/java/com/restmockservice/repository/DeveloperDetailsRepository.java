package com.restmockservice.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.restmockservice.domain.Developer;

public interface DeveloperDetailsRepository extends MongoRepository<Developer,String>{

	public Optional<Developer> findOneById(String id);
	
}
