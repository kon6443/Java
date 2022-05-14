package com.example.demo.HomeController;

import java.sql.*;
import java.util.*;

public class SQLiteJDBC {

   public static void main( String args[] ) {
//      Connection c = null;
//      Statement stmt = null;
//      
//      try {
//         Class.forName("org.sqlite.JDBC");
//         c = DriverManager.getConnection("jdbc:sqlite:database.db");
//         System.out.println("Opened database successfully");
//
//         stmt = c.createStatement();
//         String sql = "CREATE TABLE COMPANY " +
//                        "(ID INT PRIMARY KEY     NOT NULL," +
//                        " NAME           TEXT    NOT NULL, " + 
//                        " AGE            INT     NOT NULL, " + 
//                        " ADDRESS        CHAR(50), " + 
//                        " SALARY         REAL)"; 
//         stmt.executeUpdate(sql);
//         stmt.close();
//         c.close();
//      } catch ( Exception e ) {
//         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
//         System.exit(0);
//      }
//      System.out.println("Table created successfully");
   }
   public static List<String> keystrokeShow() {
	   Connection c = null;
	   Statement stmt = null;
	   List<String> returnVal = new ArrayList<String>();
	   try {
		   Class.forName("org.sqlite.JDBC");
		   c = DriverManager.getConnection("jdbc:sqlite:keystroke.db");
		   c.setAutoCommit(false);
		   stmt = c.createStatement();
		   ResultSet rs = stmt.executeQuery( "SELECT * FROM COUNTRY;" );      
		   while ( rs.next() ) {
			   int id = rs.getInt("id");
			   String  name = rs.getString("name");
			   returnVal.add(name);
		   }
		   rs.close();
		   stmt.close();
		   c.close();
	   } catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   System.exit(0);
	   }
	   return returnVal;
   }
   public static List<Person> dataShow() {
	   Connection c = null;
	   Statement stmt = null;
	   List<Person> people = new ArrayList<Person>();
	   try {
		   Class.forName("org.sqlite.JDBC");
		   c = DriverManager.getConnection("jdbc:sqlite:data.db");
		   c.setAutoCommit(false);
		   stmt = c.createStatement();
		   ResultSet rs = stmt.executeQuery( "SELECT * FROM PEOPLE;" );      
		   while(rs.next()) {
			   int id = rs.getInt("id");
			   String name = rs.getString("name");
			   int ssn = rs.getInt("ssn");
			   String state = rs.getString("state");
			   Person person = new Person(id, name, ssn, state);
			   people.add(person);
		   }
		   rs.close();
		   stmt.close();
		   c.close();
	   } catch ( Exception e ) {
		   System.err.println( e.getClass().getName() + ": " + e.getMessage() );
		   System.exit(0);
	   }
	   return people;
   }
   public static void dataPost(String name, int SSN, String state) {
	   Connection c = null;
	   Statement stmt = null;
	   try {
		   Class.forName("org.sqlite.JDBC");
		   c = DriverManager.getConnection("jdbc:sqlite:data.db");
		   c.setAutoCommit(false);
		   System.out.println("Opened database successfully");
		   stmt = c.createStatement();
		   String sql = "INSERT INTO PEOPLE (NAME,SSN,STATE) "+
	                        "VALUES ("+name+","+SSN+","+state+");"; 
		   stmt.executeUpdate(sql);
		   stmt.close();
		   c.commit();
		   c.close();
	      } catch ( Exception e ) {
	    	  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	  System.exit(0);
	      }
	   System.out.println("Records created successfully");
   }
}