package com.example.demo.HomeController;

import org.springframework.beans.factory.annotation.Value;

class User {
	private String id;
	private String address;
	private String pw;
	User(String id, String address, String pw) {
		this.id = id;
		this.address = address;
		this.pw = pw;
	}
	public String getId() {
		return this.id;
	}
	public String getAddress() {
		return this.address;
	}
	public String getState() {
		return this.pw;
	}
}

//public class User {
//	public static void main( String args[] ) {
//		
//	}
//}