package com.example.demo.HomeController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDatabaseFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoClientDatabaseFactory;
import org.springframework.stereotype.Component;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

@Configuration
//@Component
public class MongoDBConfig {

	@Value("${mongodb.test.connectionString}")
	private String connectionString;
	@Value("${test.key}")
	private String connectionStr;
	@Bean
	public MongoDatabaseFactory mongoDatabaseFactory() {
		System.out.println("MongoDBConfig bean has been called.");
		System.out.println(connectionStr);
		return new SimpleMongoClientDatabaseFactory(connectionStr);
	}

	@Bean
	public MongoTemplate mongoTemplate() {
		return new MongoTemplate(mongoDatabaseFactory());
	}
	
	public static void main( String args[] ) {
		
	}
}
