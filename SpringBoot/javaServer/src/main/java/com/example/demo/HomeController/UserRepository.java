package com.example.demo.HomeController;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

//@RequiredArgsConstructor
//@Service
//public class userService {
//	private MongoTemplate mongoTemplate;
//	public void mongoInsert(User user) {
//		mongoTemplate.insert(user);
//	}
//}

@Repository
public interface UserRepository extends MongoRepository<User, String> {
	
}

//public class User {
//	public static void main( String args[] ) {
//		
//	}
//}