package com.restmockcontroller;

import static org.junit.Assert.assertNotNull;
import static org.mockito.Matchers.anyString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.util.ReflectionTestUtils;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.restmockservice.RestMockServiceApplication;
import com.restmockservice.controller.DeveloperDetailsController;
import com.restmockservice.domain.Address;
import com.restmockservice.domain.Developer;
import com.restmockservice.domain.Skills;
import com.restmockservice.exception.NoDeveloperFoundException;
import com.restmockservice.repository.DeveloperDetailsRepository;
import com.restmockservice.service.DeveloperDetailsService;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT, classes = RestMockServiceApplication.class)
public class RestMockServiceControllerTest {
		
    @Inject
	private DeveloperDetailsRepository developerDetailsRepository;
    
    private MockMvc mockMvc;
    
    @MockBean
    private DeveloperDetailsService developerDetailsService;
	
	@Before
	public void setUp() throws Exception{	
		DeveloperDetailsService developerDetailsService = new DeveloperDetailsService();
		ReflectionTestUtils.setField(developerDetailsService, "developerDetailsRepository",	developerDetailsRepository);
		DeveloperDetailsController developerDetailsController = new DeveloperDetailsController();
		ReflectionTestUtils.setField(developerDetailsController, "developerDetailsService", developerDetailsService);		
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
		this.mockMvc = MockMvcBuilders.standaloneSetup(developerDetailsController).build();		
	}
	
	@Test
	public void testFetchData() throws Exception{
		mockMvc.perform(get("/developer/developerid/{id}", "123")
		.accept(MediaType.APPLICATION_JSON))
		.andExpect(status().isOk());
	}
	
	@SuppressWarnings("unchecked")
	@Test
	public void findDeveloperShouldReturnNoDeveloperFoundException() throws NoDeveloperFoundException {
		when(developerDetailsService.getDeveloperDetails(anyString())).thenThrow(NoDeveloperFoundException.class);
		try {
			mockMvc.perform(get("/developer/developerid/91").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
