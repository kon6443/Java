package com.example.demo.HomeController;

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
	public int getId() {
		return this.id;
	}
	public String getName() {
		return this.name;
	}
	public int getSsn() {
		return this.SSN;
	}
	public String getState() {
		return this.state;
	}
	public void introduce() {
		System.out.println("id: "+this.id+", name: "+this.name+", ssn: "+this.SSN+", state: "+this.state);
	}
}

public class Objects {
	public static void main( String args[] ) {
		
	}
}