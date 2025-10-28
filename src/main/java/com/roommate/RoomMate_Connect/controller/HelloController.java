package com.roommate.RoomMate_Connect.controller;

import org.springframework.web.bind.annotation.*;

import com.roommate.RoomMate_Connect.model.User;

import java.util.Map;


@RestController
public class HelloController {
	
	@GetMapping("api/hello")
	public Map<String, String> sayHello() {
		return Map.of("Hello" , "People");
	}


}
