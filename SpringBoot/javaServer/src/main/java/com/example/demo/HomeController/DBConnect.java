package com.example.demo.HomeController;

import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Connection;

public class DBConnect {
	private static Connection conn = null;
	public static void closeConnection() {
		if(conn != null) {
			try {
				conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static Connection getConnection() throws ClassNotFoundException {
		if(conn == null) {
			try {
				System.out.println("getConnection method has been called.");
				Class.forName("org.sqlite.JDBC");
				conn = DriverManager.getConnection("jdbc:sqlite:" + "sample.db");
			} catch(SQLException e) {
				e.printStackTrace();
			}	
		}
		return conn;
	}
//	public <TodoItem> ArrayList<TodoItem> getList() {
//		ArrayList<TodoItem> list = new ArrayList<TodoItem>();
//		Statement stmt;
//		try {
//			stmt = conn.createStatement();
//			String sql = "SELECT * FROM list";
//			ResultSet rs = stmt.executeQuery(sql);
//			while(rs.next()) {
//				int id = rs.getInt("id");
//				String country = rs.getString("country");
//				TodoItem t = new TodoItem(country);
//				t.setId(id);
//				list.add(t);
//			}
//		} catch(SQLException e) {
//			e.printStackTrace();
//		}
//	}
}