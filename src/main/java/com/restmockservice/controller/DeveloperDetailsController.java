package com.restmockservice.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessResourceFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.restmockservice.constants.AppConstants;
import com.restmockservice.domain.Developer;
import com.restmockservice.exception.DataBaseException;
import com.restmockservice.exception.NoDeveloperFoundException;
import com.restmockservice.service.DeveloperDetailsService;

@RestController
@RequestMapping(value = "/developer", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeveloperDetailsController {
	
	private final Logger logger = LoggerFactory.getLogger(DeveloperDetailsController.class);
		
    @Autowired
    private DeveloperDetailsService developerDetailsService;
	
    @RequestMapping(method = RequestMethod.GET, value = "/developerid/{developerid}")
    public ResponseEntity<Developer> getDeveloperInformation(@PathVariable("developerid") String developerid) throws Exception {
    	logger.info("Displaying the Developer with id: {}" , developerid);
    	Developer developer = null;
    	try {
    		if(developerid != null){
    			developer = developerDetailsService.getDeveloperDetails(developerid);
    		}
    	} catch (DataAccessResourceFailureException e) {
    		logger.warn("Could not connect to db");
            throw new DataBaseException(AppConstants.ERROR_NOT_CONNECT_TO_DB);	
    	}
    	if (developer == null){
             logger.warn("No Developer Details for this developerid");
             throw new NoDeveloperFoundException(AppConstants.WARN_NO_DEVELOPER_FOUND);
        }
    	ResponseEntity<Developer> responseEntity = new ResponseEntity<>(developer, HttpStatus.OK);           
    	return responseEntity;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/developers")
    public List<Developer> getDevelopers() throws Exception {
    	logger.info("Displaying the Developers");
    	List<Developer> developers = null;
    	try {
    		developers = developerDetailsService.getDevelopers();
    	} catch (DataAccessResourceFailureException e) {
    		logger.warn("Could not connect to db");
            throw new DataBaseException(AppConstants.ERROR_NOT_CONNECT_TO_DB);	
    	}
    	return developers;
    }
    
    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    public String getDeveloperHealthCheck() throws Exception {
    	return "{\"data\": \"Up and Running.\"}";  	
    }

}
