//package com.restmockservice;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.restmockservice.domain.Address;
//import com.restmockservice.domain.Developer;
//import com.restmockservice.domain.Skills;
//import com.restmockservice.repository.DeveloperDetailsRepository;
//
//import org.junit.After;
//import org.junit.Before;
//import org.springframework.beans.factory.annotation.Autowired;
//import static org.junit.Assert.*;
//
//import java.util.ArrayList;
//import java.util.List;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest
//public class RestMockServiceApplicationTests {
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
//		Developer developer1 = developerDetailsRepository.findOneById("123");
//	    assertNotNull(developer1);
//        assertEquals("John", developer1.getName());
//        assertEquals("developer", developer1.getDesignation());
//        assertEquals("valley ave", developer1.getAddress().getStreet());
//        assertEquals("Pleasanton", developer1.getAddress().getCity());
//        assertEquals("94566", developer1.getAddress().getZip());
//        assertEquals("Java", developer1.getListSkills().get(0).getSkills());
//        assertEquals("Spring", developer1.getListSkills().get(1).getSkills());
//	}
//		
//	@After
//	public void tearDown() throws Exception{
//		developerDetailsRepository.deleteAll();
//	}
//
//}
