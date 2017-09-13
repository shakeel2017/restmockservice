package com.restmockservice.controller;

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
		
    @Autowired
    private DeveloperDetailsService developerDetailsService;
	
    @RequestMapping(method = RequestMethod.GET, value = "/developerid/{developerid}")
    public Developer getDeveloperInformation(@PathVariable String developerid) throws Exception {
    	return developerDetailsService.getDeveloperDetails(developerid);
    }

}
