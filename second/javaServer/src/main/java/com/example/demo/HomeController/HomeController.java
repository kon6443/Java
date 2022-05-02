package com.example.demo.HomeController;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
// 컨트럴러 어노테이션
@Controller
public class HomeController {
	// 매핑 주소
	@RequestMapping(value = {"/", "/home.html"})
	public String home(Model model) {
		// 템플릿에 전달할 데이터
		//model.addAttribute("data", "hello world");
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
	@RequestMapping(value = {"/chat", "/chat.html"})
	public String chat(Model model) {
		return "chat";
	}
	@RequestMapping(value = {"/data", "/data.html"})
	public String data(Model model) {
		return "data";
	}
}
