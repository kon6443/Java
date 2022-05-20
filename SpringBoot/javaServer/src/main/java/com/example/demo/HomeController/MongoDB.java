package com.example.demo.HomeController;

import org.springframework.beans.factory.annotation.Value;

import com.mongodb.*;
import com.mongodb.client.*;
//import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class MongoDB {
//	public static void findUser() {
//		mongoTemplate.findOne();
//	}
	@Value("${test.key}")
	private String mongoDBURI;
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