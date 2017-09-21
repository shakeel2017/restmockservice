package com.restmockservice.config;

import org.springframework.cloud.config.java.AbstractCloudConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.mapping.event.ValidatingMongoEventListener;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

import com.mongodb.Mongo;

@Configuration
@EnableMongoRepositories("com.restmockservice.repository")
public class CloudDatabaseConfiguration extends AbstractCloudConfig {

    @Bean
    public MongoDbFactory mongoDbFactory() {
        return connectionFactory().mongoDbFactory();
    }
    
    @Bean
    public ValidatingMongoEventListener validatingMongoEventListener() {
        return new ValidatingMongoEventListener(validator());
    }
    
    @Bean
    public LocalValidatorFactoryBean validator() {
        return new LocalValidatorFactoryBean();
    }
    
    public String getDatabaseName() {
        return mongoDbFactory().getDb().getName();
    }

    public Mongo mongo() throws Exception {
        return mongoDbFactory().getDb().getMongo();
    }

}
