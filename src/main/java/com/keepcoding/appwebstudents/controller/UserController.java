package com.keepcoding.appwebstudents.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.keepcoding.appwebstudents.entity.User;
import com.keepcoding.appwebstudents.service.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService service;
	
	@GetMapping({"/","/login"})
	public String loginView() {
		return "login";		
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("email") String email, @RequestParam("password") String password, Model model) {
	    User user = service.findByEmailOrUsername(email, email);
	    if (user != null && user.getPassword().equals(password)) {
	        return "redirect:/students";
	    } else {
	        model.addAttribute("error", "Invalid username or password.");
	        return "login";
	    }
	}
	
	@GetMapping("/login/new_user")
	public String viewUserForm(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		return "new_user";
	}
	
	@PostMapping("/login/new_user")
	public String createUser(@ModelAttribute("user") User user) {
		service.createNewUser(user);
		return "redirect:/login";
	}
}
