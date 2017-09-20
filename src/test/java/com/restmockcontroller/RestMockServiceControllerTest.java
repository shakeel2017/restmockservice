package com.restmockcontroller;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;

import com.restmockservice.RestMockServiceApplication;
import com.restmockservice.controller.DeveloperDetailsController;
import com.restmockservice.domain.Address;
import com.restmockservice.domain.Developer;
import com.restmockservice.domain.Skills;
import com.restmockservice.repository.DeveloperDetailsRepository;
import com.restmockservice.service.DeveloperDetailsService;

@RunWith(SpringRunner.class)

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = RestMockServiceApplication.class)
@Transactional
public class RestMockServiceControllerTest {
	
	
    @Inject
	private DeveloperDetailsRepository developerDetailsRepository;
    
    private MockMvc mockMvc;
	
	@Before
	public void setUp() throws Exception{
		
		DeveloperDetailsService developerDetailsService = new DeveloperDetailsService();
		ReflectionTestUtils.setField(developerDetailsService, "developerDetailsRepository",	developerDetailsRepository);

		DeveloperDetailsController developerDetailsController = new DeveloperDetailsController();
		ReflectionTestUtils.setField(developerDetailsController, "developerDetailsService", developerDetailsService);
		
		Address address1= new Address("1", "valley ave", "Pleasanton", "94566");
		assertNull(address1.getId());
		developerDetailsRepository.save(address1);
		assertNotNull(address1.getId());
		Skills skills1 = new Skills("Java");
		Skills skills2 = new Skills("Spring");
		developerDetailsRepository.save(skills1);
		developerDetailsRepository.save(skills2);
		List<Skills>  listSkills = new ArrayList<Skills>();
		Developer developer1 = new Developer("123", "John", "developer", address1, listSkills);
		assertNull(developer1.getId());
		developerDetailsRepository.save(developer1);
		assertNotNull(developer1.getId());
		this.mockMvc = MockMvcBuilders.standaloneSetup(developerDetailsController).build();
		
	}
	
	@Test
	public void testFetchData() throws Exception{
		mockMvc.perform(get("/developer/{id}", "123"))
		.andExpect(status().isOk())
		.andExpect(model().size(1))
		.andExpect(model().attributeExists("developer"))
		.andExpect(model().attribute("developer", 
				allOf(
					hasProperty("id", is("123")),
					hasProperty("name", is("John")),
                    hasProperty("designation", is("developer"))
				)
		));
	}

}
