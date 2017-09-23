package com.restmockservice.controller;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restmockservice.constants.AppConstants;
import com.restmockservice.domain.Developer;
import com.restmockservice.exception.DataBaseException;
import com.restmockservice.service.DeveloperDetailsService;

@RestController
@RequestMapping(value = "/developer", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeveloperDetailsController {
	
	private final Logger logger = LoggerFactory.getLogger(DeveloperDetailsController.class);
		
    @Autowired
    private DeveloperDetailsService developerDetailsService;
	
    @RequestMapping(method = RequestMethod.GET, value = "/developerid/{developerid}")
    public Developer getDeveloperInformation(@PathVariable("developerid") String developerid) throws Exception {
    	logger.info("Displaying the Developer with id: " + developerid);
    	Developer developer = null;
    	try {
    		developer = developerDetailsService.getDeveloperDetails(developerid);
    	} catch (DataAccessResourceFailureException e) {
    		logger.warn("Could not connect to db");
            throw new DataBaseException(AppConstants.ERROR_NOT_CONNECT_TO_DB);	
    	}
    	return developer;
    }
    @RequestMapping(method = RequestMethod.GET, value = "/developers")
    public List<Developer> getDevelopers() throws Exception {
    	logger.info("Displaying the Developersß ");
    	List<Developer> developer = null;
    	try {
    		developer = developerDetailsService.getDevelopers();
    	} catch (DataAccessResourceFailureException e) {
    		logger.warn("Could not connect to db");
            throw new DataBaseException(AppConstants.ERROR_NOT_CONNECT_TO_DB);	
    	}
    	return developer;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    public String getDeveloperHealthCheck() throws Exception {
    	return "Up and Running.";  	
    }

}
