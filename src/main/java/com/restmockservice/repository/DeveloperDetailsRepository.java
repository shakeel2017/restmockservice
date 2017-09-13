package com.restmockservice.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.restmockservice.domain.Developer;

public interface DeveloperDetailsRepository extends MongoRepository<Developer,String>{
	Developer findOneById(String id);
}
