package com.markqt.sbmongocrud.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.MongoTransactionManager;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;

@Configuration
@EnableMongoRepositories(basePackages = "com.markqt.sbmongocrud.repo")
public class MongoConfig extends AbstractMongoClientConfiguration{
 
    @Bean
    MongoTransactionManager transactionManager(MongoDatabaseFactory dbFactory) {
        return new MongoTransactionManager(dbFactory);
    }
 
    @Override
    protected String getDatabaseName() {
        return "crud";
    }
 
//    @Override
//    public MongoClient mongoClient() {
//        final ConnectionString connectionString = new ConnectionString("mongodb://localhost:27017/crud");
//        final MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
//            .applyConnectionString(connectionString)
//            .build();
//        return MongoClients.create(mongoClientSettings);
//    }
}