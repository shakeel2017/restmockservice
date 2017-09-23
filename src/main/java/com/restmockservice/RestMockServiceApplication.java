package com.restmockservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.restmockservice")
public class RestMockServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestMockServiceApplication.class, args);
	}
	
}
