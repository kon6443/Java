package com.example.demo.HomeController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
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
	
//	@Autowired
//    private UserRepository userRepo;

//	private final userService userRepo = new userService();
	
	
	@Autowired
	private MongoTemplate mt;
	
	@Value("${mongoDB.uri}")
	private String mongoDBURI;
//	@Value("${test.mongodb.database}")
//	private String dbName;
	@RequestMapping(value = {"/login", "/login.html"})
	public String login(Model model) {
//		MongoDB.connectDB(mongoDBURI);
//		User user = new User("first", "first address", "firstpw");
		List<User> users = mt.findAll(User.class, "User");
		System.out.println(users);
		System.out.println("1: "+mt.findById("seven", User.class));
		System.out.println("2: "+mt.findById("62465e55af3766c38615be16", User.class));
		User user1 = mt.findById("62465e55af3766c38615be16", User.class);
		User user2 = mt.findById("seven", User.class);
		System.out.println(user1);
		System.out.println(user2);
		return "login";
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String signUp(@RequestParam String id, @RequestParam String address, @RequestParam String pw, @RequestParam String pwc) {
		if(id==null || address==null || pw==null ||pwc==null) return "data";
		if(pw!=pwc) return "data";
//		User user = new User(id, address, pw);
		
		return "data";
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
	@RequestMapping(value = {"/data", "/data.html"})
	public String data(Model model) {
		return "data";
	}
	
	@ResponseBody
	@RequestMapping(value = {"/data", "/data.html"}, method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Person> dataShow() {
		// calling a method that returning a db field.
		List<Person> people = SQLiteJDBC.dataShow();
		return people;
	}
	
	@ResponseBody
	@RequestMapping(value = "/data", method = RequestMethod.POST)
	public String dataPost(@RequestParam String name, @RequestParam int ssn, @RequestParam String state) {
		// calling a method that inserting an user info into a db field.
		SQLiteJDBC.dataPost(name, ssn, state);
		return "data";
	}
	
	@ResponseBody
	@RequestMapping(value = "/data", method = RequestMethod.DELETE)
	public String dataDelete(@RequestParam int id) {
		// calling a method that deleting 
		SQLiteJDBC.dataDelete(id);
		return "data";
	}

}
