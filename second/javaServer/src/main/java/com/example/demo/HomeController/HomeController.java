package com.example.demo.HomeController;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

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
		ProcessBuilder pb = new ProcessBuilder("python"," /pythonScript/prePopulate.py"," "+req.getParameter("country"));
		Process p = pb.start();
	
//		String command = "python /pythonScript/prePopulate.py ";
//		Process p = Runtime.getRuntime().exec(command + req.getParameter("country") );
	
	
		System.out.println("Done: " + p);
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
