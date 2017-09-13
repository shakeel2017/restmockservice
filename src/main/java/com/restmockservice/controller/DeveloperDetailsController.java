package com.restmockservice.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.MediaType;

import com.restmockservice.domain.Developer;
import com.restmockservice.service.DeveloperDetailsService;

@RestController
@RequestMapping(value = "/developer", produces = MediaType.APPLICATION_JSON_VALUE)
public class DeveloperDetailsController {
	
	@Autowired
	private DeveloperDetailsService developerDetailsService;
	
    @RequestMapping(method = RequestMethod.GET, value = "/developerid/{developerid}")
    public Developer getDeveloperInformation(@PathVariable String developerid) throws IOException {
    	return developerDetailsService.getDeveloperDetails(developerid);
    }

}
