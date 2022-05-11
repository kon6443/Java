package com.example.demo.HomeController;
import java.sql.*;

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
      
      Connection c = null;
      Statement stmt = null;
      try {
    	  Class.forName("org.sqlite.JDBC");
    	  c = DriverManager.getConnection("jdbc:sqlite:database.db");
    	  c.setAutoCommit(false);
    	  stmt = c.createStatement();
    	  ResultSet rs = stmt.executeQuery( "SELECT * FROM COUNTRY;" );
		      
    	  while ( rs.next() ) {
    		  int id = rs.getInt("id");
    		  String  name = rs.getString("name");
    		  System.out.println( "ID = " + id );
    		  System.out.println( "NAME = " + name );
    		  System.out.println();
    	  }
    	  rs.close();
    	  stmt.close();
    	  c.close();
      } catch ( Exception e ) {
    	  System.err.println( e.getClass().getName() + ": " + e.getMessage() );
    	  System.exit(0);
      }
      System.out.println("Operation done successfully");
   }
}