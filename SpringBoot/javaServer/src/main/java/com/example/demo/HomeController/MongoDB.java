package com.example.demo.HomeController;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.mongodb.*;
import com.mongodb.client.*;

//@Configuration
//@Component
public class MongoDB {
//	public static void findUser() {
//		mongoTemplate.findOne();
//	}
	@Value("${test.key}")
	private String mongoDBURI;
	@Bean
	public static void connectDB(String mongoDBURI) {
		System.out.println("mongoDBURI: "+mongoDBURI);
		try {
			ConnectionString connectionString = new ConnectionString(mongoDBURI);
			MongoClientSettings settings = MongoClientSettings.builder()
	        .applyConnectionString(connectionString)
	        .serverApi(ServerApi.builder()
	            .version(ServerApiVersion.V1)
	            .build())
	        .build();
			MongoClient mongoClient = MongoClients.create(settings);
			MongoDatabase database = mongoClient.getDatabase("Cluster0");
			System.out.println("MongoDB connected...");
		} catch(Exception e) {
			System.err.println(e.getCause());
		}
	}
	public static void signUp(String id, String address, String pw) {
	   System.out.println("id: "+id);
	   System.out.println("address: "+address);
	   System.out.println("pw: "+pw);
	}
}
