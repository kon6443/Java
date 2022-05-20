package com.example.demo;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;

import com.example.demo.HomeController.MongoDB;

@SpringBootApplication(scanBasePackages="com.example.demo*")
@Controller
public class JavaServerApplication {
//	@Value("${mongoDB.uri}")
//	private String mongoDBURI;
	public static void main(String[] args) {
		SpringApplication.run(JavaServerApplication.class, args);
//		System.out.println("mongoDBURI: "+mongoDBURI);
//		MongoDB.connectDB();
	}
	
}
