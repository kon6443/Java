package com.example.demo.HomeController;

import java.util.*;

class Person {
	private int id;
	private String name;
	private int SSN;
	private String state;
	Person(int id, String name, int SSN, String state) {
		this.id = id;
		this.name = name;
		this.SSN = SSN;
		this.state= state;
	}
	public int id() {
		return this.id;
	}
	public String name() {
		return this.name;
	}
	public int ssn() {
		return this.SSN;
	}
	public String state() {
		return this.state;
	}
}

public class Objects {
	public static void main( String args[] ) {
		
	}
}