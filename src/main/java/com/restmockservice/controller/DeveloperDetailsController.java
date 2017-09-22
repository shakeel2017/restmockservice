package com.restmockservice.controller;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restmockservice.domain.Developer;
import com.restmockservice.service.DeveloperDetailsService;

@RestController
@RequestMapping(value = "/developer", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeveloperDetailsController {
	
	private final Logger logger = LoggerFactory.getLogger(DeveloperDetailsController.class);
		
    @Autowired
    private DeveloperDetailsService developerDetailsService;
	
    @RequestMapping(method = RequestMethod.GET, value = "/developerid/{developerid}")
    public Optional<Developer> getDeveloperInformation(@PathVariable String developerid) throws Exception {
    	logger.info("Displaying the Developer with id: " + developerid);
    	return developerDetailsService.getDeveloperDetails(developerid);
    }

}
