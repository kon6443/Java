package com.example.demo.HomeController;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Service;

@Service
public class userService {
	private final MongoTemplate mongoTemplate = null;
	public void mongoInsert(User user) {
		mongoTemplate.insert(user);
	}
}
//public interface userRepository extends MongoRepository<User, String> {
//	
//}

//public class User {
//	public static void main( String args[] ) {
//		
//	}
//}