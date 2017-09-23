package com.restmockservice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;

import com.restmockservice.domain.Address;
import com.restmockservice.domain.Developer;
import com.restmockservice.domain.Skills;
import com.restmockservice.repository.DeveloperDetailsRepository;
import com.restmockservice.service.DeveloperDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class RestMockServiceApplicationTest {
	
    @Inject
    private DeveloperDetailsService developerDetailsService;
	
    @Inject
	private DeveloperDetailsRepository developerDetailsRepository;
	
	@Before
	public void setUp() throws Exception{
		Address address1= new Address("1", "valley ave", "Pleasanton", "94566");
		assertNotNull(address1.getId());
		Skills skills1 = new Skills("Java");
		Skills skills2 = new Skills("Spring");
		List<Skills>  listSkills = new ArrayList<Skills>();
		listSkills.add(skills1);
		listSkills.add(skills2);		
		Developer developer1 = new Developer("123", "John", "developer", address1, listSkills);
		developerDetailsRepository.save(developer1);
		assertNotNull(developer1.getId());	
	}
	
	@Test
	public void testFetchData() throws Exception{
		Developer developer1 = developerDetailsService.getDeveloperDetails("123");
	    assertNotNull(developer1);
	        assertEquals("John", developer1.getName());
	        assertEquals("developer", developer1.getDesignation());
	        assertEquals("valley ave", developer1.getAddress().getStreet());
	        assertEquals("Pleasanton", developer1.getAddress().getCity());
	        assertEquals("94566", developer1.getAddress().getZip());
	        assertEquals("Java", developer1.getListSkills().get(0).getSkills());
	        assertEquals("Spring", developer1.getListSkills().get(1).getSkills());
	}

}
