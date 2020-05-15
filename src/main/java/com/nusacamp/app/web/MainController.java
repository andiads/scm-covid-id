package com.nusacamp.app.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.nusacamp.app.service.UserService;

@Controller
public class MainController {
	@Autowired
	private UserService userService;
	
	
	@GetMapping("/")
	public String root() {
		return "index";
	}
	@GetMapping("/login")
	public String login(Model model) {
		return "login";
	}
	@GetMapping("/login_user")
	public String loginUser(Model model) {
		return "login_user";
	}
	@GetMapping("/index_admin")
	public String adminIndex(Model model) {
		return "index_admin";
	}
	@GetMapping("/user")
	public String userIndex() {
		return "user/index";
	}

}