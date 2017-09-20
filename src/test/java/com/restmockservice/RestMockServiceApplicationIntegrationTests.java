//package com.restmockservice;
//
//import static org.junit.Assert.assertEquals;
//import static org.junit.Assert.assertNotNull;
//import static org.junit.Assert.assertNull;
//
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Optional;
//
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.restmockservice.domain.Address;
//import com.restmockservice.domain.Developer;
//import com.restmockservice.domain.Skills;
//import com.restmockservice.repository.DeveloperDetailsRepository;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RestMockServiceApplicationIntegrationTests {
//	
//	@Autowired
//	private DeveloperDetailsRepository developerDetailsRepository;
//	
//	@Before
//	public void setUp() throws Exception{
//		Address address1= new Address("1", "valley ave", "Pleasanton", "94566");
//		assertNull(address1.getId());
//		developerDetailsRepository.save(address1);
//		assertNotNull(address1.getId());
//		Skills skills1 = new Skills("1", "Java");
//		Skills skills2 = new Skills("2", "Spring");
//		assertNull(skills1.getId());
//		assertNull(skills2.getId());
//		developerDetailsRepository.save(skills1);
//		developerDetailsRepository.save(skills2);
//		assertNotNull(skills1.getId());
//		assertNotNull(skills2.getId());
//		List<Skills>  listSkills = new ArrayList<Skills>();
//		Developer developer1 = new Developer("123", "John", "developer", address1, listSkills);
//		assertNull(developer1.getId());
//		developerDetailsRepository.save(developer1);
//		assertNotNull(developer1.getId());	
//	}
//	
//	@Test
//	public void testFetchData(){
//		Optional<Developer> developer1 = developerDetailsRepository.findOneById("123");
//	    assertNotNull(developer1);
//	    if(developer1.isPresent()){
//	        assertEquals("John", developer1.get().getName());
//	        assertEquals("developer", developer1.get().getDesignation());
//	        assertEquals("valley ave", developer1.get().getAddress().getStreet());
//	        assertEquals("Pleasanton", developer1.get().getAddress().getCity());
//	        assertEquals("94566", developer1.get().getAddress().getZip());
//	        assertEquals("Java", developer1.get().getListSkills().get(0).getSkills());
//	        assertEquals("Spring", developer1.get().getListSkills().get(1).getSkills());
//	    }
//	}
//		
//	@After
//	public void tearDown() throws Exception{
//		developerDetailsRepository.deleteAll();
//	}
//
//}
