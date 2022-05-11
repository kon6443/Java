package com.example.demo.HomeController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.sql.*;


// controller annotation
@Controller
public class HomeController {
	@RequestMapping(value = {"/", "/home.html"})
	public String home(Model model) {
		// 템플릿에 전달할 데이터
		//model.addAttribute("data", "hello world")
		// 템플릿 파일명
		return "home";
	}
	@RequestMapping(value = {"/login", "/login.html"})
	public String login(Model model) {
		return "login";
	}
	@RequestMapping(value = {"/keystroke", "/keystroke.html"})
	public String keystroke(Model model) {
		return "keystroke";
	}
	

	
//	@ResponseBody
	@RequestMapping(value = "/keystroke/:country",method = RequestMethod.GET)
    public String keystrokeSend(Model model, HttpServletRequest req) throws IOException{
		System.out.println(req.getParameter("country"));
		
//		database.db
		
		
		String dbFileUrl = "jdbc:sqlite:/database.db";
//		try {
//			Class.forName("org.sqlite.JDBC");
//			con = DriverManager.getConnection(dbFileUrl);
//			System.out.println("sqlite db connected...");
//			
//			stmt = con.createStatement();
//			rs = stmt.executeQuery("SELECT * FROM COUNTRY");
//			
//		} catch(Exception e) {
//			System.out.println("exception: " + e);
//		}
		
		SQLiteJDBC.main(null);
		
		
//		try {
//			DBConnect.getConnection();
//		} catch (ClassNotFoundException e) {
//			e.printStackTrace();
//		}
		
		
		
		//this is real.
		
		String cursor = req.getParameter("country");
//        for(int i=0;i<countries.length;i++) {
//            if(countries[i].substring(0,cursor.length()).toLowerCase().contains(cursor.toLowerCase())) {
//                System.out.println(countries[i]);
//            }
//        }
		
		
        return "keystroke";
    }

	
	@RequestMapping(value = {"/chat", "/chat.html"})
	public String chat(Model model) {
		return "chat";
	}
	@RequestMapping(value = {"/data", "/data.html"})
	public String data(Model model) {
		return "data";
	}

}
