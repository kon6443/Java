package com.example.demo.HomeController;

//import java.awt.PageAttributes.MediaType;
import org.springframework.http.MediaType;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


// controller annotation
@Controller
public class HomeController {
	@RequestMapping(value = {"/", "/home.html"})
	public String home(Model model) {
		// data that is sent to the template.
		// model.addAttribute("data", "hello world")
		// template file name.
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
	
	@ResponseBody
	@RequestMapping(value = "/keystroke/:country",method = RequestMethod.GET)
    public List<String> keystrokeSend(Model model, HttpServletRequest req) throws IOException{
		
		// Fetching all data in a SQLite db.
		List<String> countries = SQLiteJDBC.keystrokeShow();
		
		// country variable that is typed from front side.
		String cursor = req.getParameter("country");
		
		// Declaring a variable to return at the end of the function.
		List<String> returnVal = new ArrayList<String>();
		
		// Appending a country if matched pre-populatetable word exists.
        for(int i=0;i<countries.size();i++) {
            if(countries.get(i).substring(0,cursor.length()).toLowerCase().contains(cursor.toLowerCase())) {
            	// appending a matched country into a return value.
                returnVal.add(countries.get(i));
            }
        }
        return returnVal;
    }

	
	@RequestMapping(value = {"/chat", "/chat.html"})
	public String chat(Model model) {
		return "chat";
	}
//	@ResponseBody
	@RequestMapping(value = {"/data", "/data.html"},method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> data(Model model) {
//	public String data(Model model) {
		System.out.println("I am called.");
		List<Person> people = SQLiteJDBC.dataShow();
		for(int i=0;i<people.size();i++) {
			people.get(i).introduce();
			System.out.println(people.get(i).name);
		}
		return people;
//		return "data";
	}
	
//	@ResponseBody
	@RequestMapping(value = "/data",method = RequestMethod.POST)
//	public String dataSend(@RequestBody String body) {
	public String dataSend(@RequestParam String name, @RequestParam String ssn, @RequestParam String state) {
		SQLiteJDBC.dataShow();
		return "data";
	}

}
