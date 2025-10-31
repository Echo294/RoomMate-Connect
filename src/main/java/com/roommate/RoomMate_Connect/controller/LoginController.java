package com.roommate.RoomMate_Connect.controller;

import com.roommate.RoomMate_Connect.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.roommate.RoomMate_Connect.repository.UserRepository;


@Controller
public class LoginController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping("/login")
	public String showLoginPage() {
		return "login";
	}
	
	@PostMapping("/login")
	public String processLogin(@RequestParam String username, @RequestParam String password, Model model) {
		User user = userRepository.findByUsername(username);

		if (user != null && user.getPassword().equals(password)) {
			// on successful login redirect to the room page
			// store username in the model or session if templates need it
			model.addAttribute("username", username);
			return "redirect:/room";
		} else {
			model.addAttribute("error", "Invalid login credentials");
			return "login";
		}
	}
	
	
}
