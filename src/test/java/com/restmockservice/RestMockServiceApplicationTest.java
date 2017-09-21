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
//import javax.inject.Inject;
//
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.transaction.annotation.Transactional;
//
//import com.restmockservice.domain.Address;
//import com.restmockservice.domain.Developer;
//import com.restmockservice.domain.Skills;
//import com.restmockservice.repository.DeveloperDetailsRepository;
//import com.restmockservice.service.DeveloperDetailsService;
//
//@RunWith(SpringRunner.class)
//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
//@Transactional
//public class RestMockServiceApplicationTest {
//	
//    @Inject
//    private DeveloperDetailsService developerDetailsService;
//	
//    @Inject
//	private DeveloperDetailsRepository developerDetailsRepository;
//	
//	@Before
//	public void setUp() throws Exception{
//		Address address1= new Address("1", "valley ave", "Pleasanton", "94566");
//		assertNull(address1.getId());
//		developerDetailsRepository.save(address1);
//		assertNotNull(address1.getId());
//		Skills skills1 = new Skills("Java");
//		Skills skills2 = new Skills("Spring");
//		developerDetailsRepository.save(skills1);
//		developerDetailsRepository.save(skills2);
//		List<Skills>  listSkills = new ArrayList<Skills>();
//		Developer developer1 = new Developer("123", "John", "developer", address1, listSkills);
//		assertNull(developer1.getId());
//		developerDetailsRepository.save(developer1);
//		assertNotNull(developer1.getId());	
//	}
//	
//	@Test
//	public void testFetchData() throws Exception{
//		Optional<Developer> developer1 = developerDetailsService.getDeveloperDetails("123");
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
//}
