package com.example.demo.HomeController;

import java.sql.*;
import java.util.*;

public class SQLiteJDBC {
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
   public static void dataPost(String name, int ssn, String state) {
	   Connection c = null;
	   Statement stmt = null;
	   try {
		   Class.forName("org.sqlite.JDBC");
		   c = DriverManager.getConnection("jdbc:sqlite:data.db");
		   c.setAutoCommit(false);
		   stmt = c.createStatement();
		   String sql = "INSERT INTO PEOPLE (NAME,SSN,STATE) "+
	                        "VALUES ('"+name+"','"+ssn+"','"+state+"');";
		   stmt.executeUpdate(sql);
		   stmt.close();
		   c.commit();
		   c.close();
	      } catch ( Exception e ) {
	    	  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	  System.exit(0);
	      }
   }
   public static void dataDelete(int id) {
	   Connection c = null;
	   Statement stmt = null;
	   try {
		   Class.forName("org.sqlite.JDBC");
		   c = DriverManager.getConnection("jdbc:sqlite:data.db");
		   c.setAutoCommit(false);
		   stmt = c.createStatement();
		   String sql = "DELETE FROM PEOPLE WHERE id="+id+";";
		   stmt.executeUpdate(sql);
		   stmt.close();
		   c.commit();
		   c.close();
	      } catch ( Exception e ) {
	    	  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	    	  System.exit(0);
	      }
   }
}