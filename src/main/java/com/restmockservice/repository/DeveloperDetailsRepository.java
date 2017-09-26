package com.restmockservice.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.restmockservice.domain.Developer;

public interface DeveloperDetailsRepository extends CrudRepository<Developer,String>{
	public Developer findOneById(String id);
	public List<Developer> findAll();
}
