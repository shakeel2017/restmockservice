package com.restmockservice.config;

import javax.inject.Inject;

import org.springframework.boot.autoconfigure.mongo.MongoAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.config.AbstractMongoConfiguration;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories("com.restmockservice.repository")
@Import(value = MongoAutoConfiguration.class)
public class CloudMongoDbConfiguration extends AbstractMongoConfiguration  {
	
	@Inject
	private MongoDbFactory mongoDbFactory;
    
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }
    
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
    
    @Override
    protected String getDatabaseName() {
        return mongoDbFactory.getDb().getName();
    }

    @Override
    public Mongo mongo() throws Exception {
        return mongoDbFactory().getDb().getMongo();
    }
}
