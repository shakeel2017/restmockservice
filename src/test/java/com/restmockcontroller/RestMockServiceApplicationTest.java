package com.restmockcontroller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import com.restmockservice.RestMockServiceApplication;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = RestMockServiceApplication.class)
@WebAppConfiguration
public class RestMockServiceApplicationTest {

	@Test
	public void contextLoads() {
	}

}
