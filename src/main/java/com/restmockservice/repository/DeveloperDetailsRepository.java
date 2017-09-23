package com.restmockservice.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.restmockservice.domain.Developer;

public interface DeveloperDetailsRepository extends CrudRepository<Developer,String>{
	public Optional<Developer> findOneById(String id);
}
