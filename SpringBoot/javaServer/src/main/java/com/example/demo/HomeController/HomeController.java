package com.example.demo.HomeController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestMethod;
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
		List<String> countries = SQLiteJDBC.select();
		
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
	@RequestMapping(value = {"/data", "/data.html"})
	public String data(Model model) {
		return "data";
	}
	
	@ResponseBody
	@RequestMapping(value = "/data",method = RequestMethod.POST)
	public String dataSend(Model model, HttpServletRequest req) {
		String cursor = req.getParameter("country");
		return "data";
	}

}
