package com.example.demo.HomeController;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import lombok.Getter;
import lombok.Setter;
import lombok.Builder;
import lombok.Data;

@Data
@Getter
@Setter
@Document(collection = "User")
class User {
	@Id
	private String id;
	@Field("address")
	private String address;
	@Field("pw")
	private String pw;
	@Builder
	User(String id, String address, String pw) {
		this.id = id;
		this.address = address;
		this.pw = pw;
	}
//	public String getId() {
//		return this.id;
//	}
//	public String getAddress() {
//		return this.address;
//	}
//	public String getState() {
//		return this.pw;
//	}
//	@Override
//	public String toString() {
//		return "Person{" +
//		         "name='" + id + '\'' +
//		         ", SSN='" + address + '\'' +
//		         ", state='" + pw + '\'' +
//		         '}';
//	}
}

//public class User {
//	public static void main( String args[] ) {
//		
//	}
//}